package interpret.syntax;

public enum Command {

    UNKNOWN ("Unknown"),

    DEF ("def"),

    NEW ("new"),
    SET ("set"),
    GET ("get"),
    INVOKE ("invoke"),

    ARRAY ("array"),

    SHOW ("show"),

    PRINT ("print"),
    EXIT ("exit"),
    ;

    private final String name;

    Command(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static Command parse(String name) {

        for (Command command: Command.values()) {
            if (name.equals(command.toString())) {
                return command;
            }
        }
        return Command.UNKNOWN;
    }

}
