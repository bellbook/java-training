package ch01.ex01_14;

public class Ex01_14 {

    public static void main(String[] args) {
        Walkman walkman = new Walkman();
        walkman.play();
        walkman.useTerminal();

        Walkman2 walkman2 = new Walkman2();
        walkman2.play();
        walkman2.useTerminal();
        walkman2.useAnotherTerminal();

        Walkman3 walkman3 = new Walkman3();
        walkman3.play();
        walkman3.useTerminal();
        walkman3.useAnotherTerminal();
        walkman3.talk();
    }

}
