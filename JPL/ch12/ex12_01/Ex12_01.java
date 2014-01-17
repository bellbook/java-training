package ch12.ex12_01;

public class Ex12_01 {

    // nullだとチェックするのを忘れるから
    // 見つからなかったオブジェクト

    public static void main(String[] args) {

        LinkedList<Integer> integerList = new LinkedList<Integer>();

        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        try {
            System.out.println(integerList.find(2));
        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(integerList.find(5));
        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
        }
    }

}
