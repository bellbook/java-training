package ch01.ex01_16;

public class Ex01_16 {

    public static void main(String[] args) {
        try {
            method();
        } catch (BadDataSetException e) {
            System.err.println("name = " + e.name);
            System.err.println("e    = " + e.e);
            e.printStackTrace();
        }
    }

    public static void method() throws BadDataSetException {
        BadDataSetException e = new BadDataSetException();
        e.name = "DataSet1";
        throw e;
    }

}
