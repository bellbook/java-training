package interpret.syntax;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SyntaxParser {

    public static Context parse(String sentence) throws SyntaxException {

        Context context = new Context();

        int equalNum = contains(sentence, "=");
        if (equalNum == 1) {
            String[] multi = sentence.split("=");
            if (multi.length != 2)
                throw new SyntaxException("The position of \'=\' is wrong.");

            context = parseDefinition(multi[0], context);
            context = parseInstruction(multi[1], context);
        } else if (equalNum == 0) {
            context = parseInstruction(sentence, context);
        } else {
            throw new SyntaxException("The number of \'=\' must be 0 or 1.");
        }

        return context;
    }

    private static Context parseDefinition(String sentence, Context syntax)
            throws SyntaxException {

        String[] token = sentence.trim().split("[\\s]+");
        if (token.length != 1)
            throw new SyntaxException("The definition is not correct.");

        if (token[0].matches("[a-zA-Z_]+?\\w*?")
                || token[0].matches("[a-zA-Z_]+?\\w*?\\[\\d+?\\]")) {
            syntax = new Context().setVariable(token[0]);
            return syntax;
        }

        throw new SyntaxException("The variable's name is not correct.");
    }

    private static Context parseInstruction(String sentence, Context syntax)
            throws SyntaxException {

        String[] args = null;
        String[] token = sentence.trim().split("[\\s]+");

        Command command = Command.parse(token[0]);
        switch (command) {

        case NEW:
        case INVOKE:
        case ARRAY:
            final int argStart = 2;
            args = new String[token.length - argStart];
            System.arraycopy(token, argStart, args, 0, args.length);
            syntax.setCommand(command).setName(token[1]).setArgs(args);
            return syntax;

        case SET:
            if (token.length != 3)
                throw new SyntaxException("The command is not correct.");

            args = new String[1];
            System.arraycopy(token, 2, args, 0, 1);
            syntax.setCommand(command).setName(token[1]).setArgs(args);
            return syntax;

        case GET:
            syntax.setCommand(command).setName(token[1]);
            return syntax;

        case SHOW:
        case PRINT:
            if (token.length != 2)
                throw new SyntaxException("The command is not correct.");

            args = new String[1];
            System.arraycopy(token, 1, args, 0, 1);
            syntax.setCommand(command).setArgs(args);
            return syntax;

        case EXIT:
            if (token.length != 1)
                throw new SyntaxException("The command is not correct.");

            syntax.setCommand(command);
            return syntax;

        default:
            throw new SyntaxException("The instruction is not correct.");
        }

    }

    private static int contains(String input, String regex) {

        Matcher m = Pattern.compile(regex).matcher(input);
        int count = 0;
        while (m.find())
            count++;
        return count;
    }

}
