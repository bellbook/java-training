package ch05.ex05_02;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private long number;
    @SuppressWarnings("unused")
    private long balance;
    private History history = new History();

    public BankAccount(long number) {
        this.number = number;
    }

    public class Action {
        private String act;
        private long amount;

        Action(String act, long amount) {
            this.act = act;
            this.amount = amount;
        }

        public String toString() {
            return number + ": " + act + " " + amount;
        }
    }

    public void deposit(long amount) {
        balance += amount;
        history.add(new Action("deposit", amount));
    }

    public void withdraw(long amount) {
        balance -= amount;
        history.add(new Action("withdraw", amount));
    }

    public Action history() {
        return history.next();
    }

    public static class History {

        private static final int NUM = 10;
        private List<Action> actionList = new ArrayList<Action>();

        public Action next() {

            if (actionList.isEmpty())
                return null;
            else
                return actionList.remove(0);

        }

        public void add(Action action) {

            if (actionList.size() < NUM) {
                actionList.add(action);
            } else {
                actionList.remove(0);
                actionList.add(action);
            }

        }
    }

}
