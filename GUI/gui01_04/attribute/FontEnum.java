package gui01_04.attribute;

public enum FontEnum {

    ARIAL           ("Arial"),
    CENTURY         ("Century"),
    COURIER         ("Courier"),
    COURIER_NEW     ("Courier New"),
    TIMES_NEW_ROMAN ("Times New Roman"),
    HELVETICA       ("Helvetica"),

    SERIF           ("Serif"),
    SANS_SERIF      ("SansSerif"),
    MONO_SPACED     ("MonoSpaced"),
    DIALOG          ("Dialog"),
    DIALOG_INPUT    ("DialogInput"),
    ;

    private final String name;

    FontEnum(String name) {
        this.name = name;
    }

    public String getFont() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}
