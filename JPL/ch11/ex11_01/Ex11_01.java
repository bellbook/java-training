package ch11.ex11_01;

public class Ex11_01 {

    public static void main(String[] args) {

        LinkedList<Integer> integerList = new LinkedList<Integer>();

        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        integerList.print();

        LinkedList<String> stringList = new LinkedList<String>();

        stringList.add("a");
        stringList.add("b");
        stringList.add("c");

        stringList.print();
    }

}
