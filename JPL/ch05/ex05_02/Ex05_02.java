package ch05.ex05_02;

public class Ex05_02 {

    public static void main(String[] args) {

        BankAccount ba = new BankAccount(4649);
        ba.deposit(100);
        ba.deposit(200);
        ba.deposit(300);
        ba.withdraw(400);
        ba.deposit(500);

        for (int i = 0; i < 7; i++) {
            System.out.println(ba.history());
        }

        ba.deposit(600);
        ba.deposit(700);
        ba.withdraw(800);
        ba.deposit(900);
        ba.deposit(1000);
        for (int i = 0; i < 7; i++) {
            System.out.println(ba.history());
        }
    }

}
