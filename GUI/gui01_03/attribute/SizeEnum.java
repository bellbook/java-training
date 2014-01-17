package gui01_03.attribute;

public enum SizeEnum {

    _12 (12, "12"),
    _14 (14, "14"),
    _16 (16, "16"),
    _18 (18, "18"),
    _20 (20, "20"),
    _24 (24, "24"),
    _28 (28, "28"),
    _32 (32, "32"),
    _36 (36, "36"),
    _40 (40, "40"),
    _44 (44, "44"),
    _48 (48, "48"),
    _54 (54, "54"),
    _60 (60, "60"),
    ;

    private final int size;
    private final String name;

    SizeEnum(int num, String name) {
        this.size = num;
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return name;
    }

}
