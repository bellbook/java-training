package ch20.ex20_07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Attr {

    private final String name;
    private Object value = null;

    public Attr(String name) {
        this.name = name;
    }

    public Attr(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    public Object setValue(Object newValue) {
        Object oldVal = value;
        value = newValue;
        return oldVal;
    }

    public String toString() {
        return name + "='" + value + "'";
    }

    public void writeData(DataOutputStream out) throws IOException {

        if (name == null || value == null)
            return;

        out.writeUTF(name);

        if (value instanceof Boolean) {
            out.writeUTF("Boolean");
            out.writeBoolean((Boolean) value);
        } else if (value instanceof Byte) {
            out.writeUTF("Byte");
            out.writeByte((Byte) value);
        } else if (value instanceof Character) {
            out.writeUTF("Character");
            out.writeChar((Character) value);
        } else if (value instanceof Double) {
            out.writeUTF("Double");
            out.writeDouble((Double) value);
        } else if (value instanceof Float) {
            out.writeUTF("Float");
            out.writeFloat((Float) value);
        } else if (value instanceof Integer) {
            out.writeUTF("Integer");
            out.writeInt((Integer) value);
        } else if (value instanceof Long) {
            out.writeUTF("Long");
            out.writeLong((Long) value);
        } else if (value instanceof Short) {
            out.writeUTF("Short");
            out.writeShort((Short) value);
        } else if (value instanceof String) {
            out.writeUTF("String");
            out.writeUTF((String) value);
        } else {

        }

        out.close();
    }

    public Attr(DataInputStream in) throws IOException {

        name = in.readUTF();

        String type = in.readUTF();

        if (type.equals("Boolean"))
            value = in.readBoolean();
        else if (type.equals("Byte"))
            value = in.readByte();
        else if (type.equals("Character"))
            value = in.readChar();
        else if (type.equals("Double"))
            value = in.readDouble();
        else if (type.equals("Float"))
            value = in.readFloat();
        else if (type.equals("Integer"))
            value = in.readInt();
        else if (type.equals("Long"))
            value = in.readLong();
        else if (type.equals("Short"))
            value = in.readShort();
        else if (type.equals("String"))
            value = in.readUTF();
        else
            ;

        in.close();
    }

}
