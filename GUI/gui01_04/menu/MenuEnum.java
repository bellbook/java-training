package gui01_04.menu;

enum MenuEnum {

    PROPERTY ("Property"),
    ;

    private final String name;

    MenuEnum(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
