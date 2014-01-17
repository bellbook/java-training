package interpret;

import interpret.gui.ShowDialog;
import interpret.syntax.Command;
import interpret.syntax.Context;
import interpret.syntax.SyntaxException;
import interpret.syntax.SyntaxParser;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import reflect.Reflection;

public class Interpreter implements Observer {

    private Map<String, Object> variables = new HashMap<String, Object>();

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof String == false)
            return;

        String sentence = (String) arg;
        System.out.println(">> " + sentence);
        try {
            interpret(sentence);
        } catch (InterpretException e) {
            System.out.println("Interpret Error!");
            if (e.getMessage() != null)
                System.out.println(e.getMessage());
        }
        System.out.println();
    }

    public void interpret(String sentence) throws InterpretException {

        Context context = null;
        try {
            context = SyntaxParser.parse(sentence);
        } catch (SyntaxException e) {
            System.out.println("Syntax Error!");
            if (e.getMessage() != null)
                System.out.println(e.getMessage());
            return;
        }
        interpret(context);
    }

    private void interpret(Context context) throws InterpretException {

        Command command = context.getCommand();
        String name = context.getName();
        String[] argName = context.getArgs();

        Class<?>[] argType = new Class[argName.length];
        Object[] argVal = new Object[argName.length];

        for (int i = 0; i < argName.length; i++) {
            try {
                argVal[i] = checkType(argName[i]);
            } catch (Exception e) {
                throw new InterpretException(
                        "The Type of the argument is unknown.");
            }

            if (argVal[i] != null)
                argType[i] = toPrimitive(argVal[i].getClass());
        }

        Object obj = null;
        Member member = null;
        switch (command) {
        case NEW:
            if (isArrayElement(context.getVariable())) {
                Array array = interpretArray(context.getVariable());
                try {
                    obj = Reflection.newInstance(name, argType, argVal);
                } catch (Throwable e) {
                    System.out.println(e);
                }
                try {
                    Reflection.setArray(array.obj, array.index, obj);
                } catch (Throwable e) {
                    System.out.println(e);
                }
            } else {
                try {
                    obj = Reflection.newInstance(name, argType, argVal);
                    variables.put(context.getVariable(), obj);
                } catch (Throwable e) {
                    System.out.println(e);
                }
            }
            break;

        case SET:
            member = interpretMember(name);
            Reflection.setField(member.obj, member.name, argVal[0]);
            break;

        case GET:
            member = interpretMember(name);
            obj = Reflection.getField(member.obj, member.name);
            variables.put(context.getVariable(), obj);
            break;

        case INVOKE:
            member = interpretMember(name);
            try {
                obj = Reflection.invoke(member.obj, member.name, argType,
                        argVal);
                variables.put(context.getVariable(), obj);
            } catch (Throwable e) {
                System.out.println(e);
            }
            break;

        case ARRAY:
            int[] dimensions = new int[argVal.length];
            for (int i = 0; i < dimensions.length; i++) {
                if (argType[i] != int.class)
                    throw new InterpretException("The dimensions are not int.class.");
                dimensions[i] = (Integer) argVal[i];
            }
            try {
                obj = Reflection.newArray(name, dimensions);
                variables.put(context.getVariable(), obj);
            } catch (Throwable e) {
                System.out.println(e);
            }
            break;

        case SHOW:
            if (argVal[0] == null)
                throw new InterpretException("The arg is null.");

            if (argVal[0] instanceof Class) {
                ShowDialog dialog = new ShowDialog((Class<?>) argVal[0]);
                dialog.show();
            } else {
                ShowDialog dialog = new ShowDialog(argName[0], argVal[0]);
                dialog.show();
            }
            break;

        case PRINT:
            System.out.println(argVal[0]);
            break;

        case EXIT:
            System.exit(0);
            break;
        }
    }

    private Array interpretArray(String sentence) {

        Pattern p = Pattern.compile("(\\w+)\\[(\\d+)\\]");
        Matcher m = p.matcher(sentence);
        m.find();

        Array array = new Array();
        array.obj = variables.get(m.group(1));
        array.index = Integer.parseInt(m.group(2));
        return array;
    }

    private class Array {
        Object obj;
        int index;
    }

    private Member interpretMember(String sentence) throws InterpretException {

        int dotNum = contains(sentence, "\\.");
        if (dotNum != 1)
            throw new InterpretException("The command is not correct.");

        String[] str = sentence.split("\\.");
        if (str.length != 2)
            throw new InterpretException("The position of \'.\' is wrong.");

        String objName = str[0];
        String memberName = str[1];

        Object obj;
        if (isArrayElement(objName)) {
            Array array = interpretArray(objName);
            obj = Reflection.getArray(array.obj, array.index);
        } else {
            obj = variables.get(objName);
        }
        if (obj == null)
            throw new InterpretException(objName + " is not found.");

        Member member = new Member();
        member.obj = obj;
        member.name = memberName;
        return member;
    }

    private class Member {
        Object obj;
        String name;
    }

    private Object checkType(String arg) throws Exception {

        if (isString(arg)) {
            String obj = arg.substring(1, arg.length() - 1);
            return obj;
        } else if (isCharacter(arg)) {
            Character obj = arg.substring(1, arg.length() - 1).charAt(0);
            return obj;
        } else if (isBoolean(arg)) {
            Boolean obj = Boolean.parseBoolean(arg);
            return obj;
        } else if (isInteger(arg)) {
            Integer obj = Integer.parseInt(arg);
            return obj;
        } else if (isLong(arg)) {
            Long obj = Long.parseLong(arg.substring(0, arg.length() - 1));
            return obj;
        } else if (isDouble(arg)) {
            Double obj = Double.parseDouble(arg);
            return obj;
        } else if (isArrayElement(arg)) {
            Pattern p = Pattern.compile("(\\w+)\\[(\\d+)\\]");
            Matcher m = p.matcher(arg);
            m.find();
            return Reflection.getArray(variables.get(m.group(1)),
                    Integer.parseInt(m.group(2)));
        } else if (isClass(arg)) {
            try {
                return Class.forName(arg);
            } catch (ClassNotFoundException e) {
                throw new AssertionError(e);
            }
        } else {
            Object obj = variables.get(arg);
            if (obj == null)
                throw new Exception();
            return obj;
        }
    }

    private static boolean isString(String arg) {
        return arg.matches("\".+?\"");
    }

    private static boolean isCharacter(String arg) {
        return arg.matches("\'.+?\'");
    }

    private static boolean isBoolean(String arg) {
        return (arg.equals("true") || arg.equals("false"));
    }

    private static boolean isInteger(String arg) {
        try {
            Integer.parseInt(arg);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isLong(String arg) {
        if (arg.endsWith("L") == false)
            return false;

        try {
            Long.parseLong(arg.substring(0, arg.length() - 1));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isDouble(String arg) {
        try {
            Double.parseDouble(arg);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isArrayElement(String arg) {
        return arg.matches("\\w+\\[\\d+\\]");
    }

    private static boolean isClass(String arg) {
        try {
            Class.forName(arg);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private static Class<?> toPrimitive(Class<?> clazz) {
        if (clazz == Boolean.class)
            return boolean.class;
        else if (clazz == Byte.class)
            return byte.class;
        else if (clazz == Character.class)
            return char.class;
        else if (clazz == Short.class)
            return short.class;
        else if (clazz == Integer.class)
            return int.class;
        else if (clazz == Long.class)
            return long.class;
        else if (clazz == Float.class)
            return float.class;
        else if (clazz == Double.class)
            return double.class;
        else
            return clazz;
    }

    private static int contains(String input, String regex) {
        Matcher m = Pattern.compile(regex).matcher(input);
        int count = 0;
        while (m.find())
            count++;
        return count;
    }

}
