package interpret.syntax;

import java.util.Arrays;

public class Context {

    private String variable;

    private Command command;

    private String name;

    private String[] args = new String[0];

    public String getVariable() {
        return variable;
    }

    public Context setVariable(String variable) {
        this.variable = variable;
        return this;
    }

    public Command getCommand() {
        return command;
    }

    public Context setCommand(Command command) {
        this.command = command;
        return this;
    }

    public String getName() {
        return name;
    }

    public Context setName(String name) {
        this.name = name;
        return this;
    }

    public String[] getArgs() {
        if (args == null)
            return null;
        return args.clone();
    }

    public Context setArgs(String[] args) {
        if (args != null)
            this.args = args.clone();
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Context [variable=");
        builder.append(variable);
        builder.append(", command=");
        builder.append(command);
        builder.append(", name=");
        builder.append(name);
        builder.append(", args=");
        builder.append(Arrays.toString(args));
        builder.append("]");
        return builder.toString();
    }

}
