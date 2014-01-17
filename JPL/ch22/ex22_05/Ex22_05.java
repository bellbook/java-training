package ch22.ex22_05;

public class Ex22_05 {

    public static void main(String[] args) {

        final int diceNum = 3;
        final int times = 10000;

        double[] pTheory = theory(diceNum);
        double[] pExperiment = shootDice(diceNum, times);

        System.out.println("Dice = " + diceNum + ", Times = " + times);
        System.out.printf(" sum \t theory \t experiment \t difference%n");

        for (int i = diceNum; i < pTheory.length; i++)
            System.out.printf(" %3d \t %.4f \t %.4f \t %.4f%n", i, pTheory[i],
                    pExperiment[i], Math.abs(pTheory[i] - pExperiment[i]));
    }

    private static double[] theory(int diceNum) {

        int[] outcomes = new int[Dice.FACE * diceNum + 1];

        Counter[] counter = new Counter[diceNum];
        for (int i = 0; i < counter.length; i++)
            counter[i] = new Counter((int) Math.pow(Dice.FACE, i));

        int allcases = (int) Math.pow(Dice.FACE, diceNum);

        for (int i = 0; i < allcases; i++) {
            int sum = 0;
            for (int j = 0; j < counter.length; j++)
                sum += counter[j].next();

            outcomes[sum]++;
        }

        double[] p = new double[outcomes.length];
        for (int i = 0; i < p.length; i++)
            p[i] = (double) outcomes[i] / allcases;

        return p;
    }

    private static double[] shootDice(int diceNum, int times) {

        int[] count = new int[Dice.FACE * diceNum + 1];

        Dice[] dice = new Dice[diceNum];
        for (int i = 0; i < dice.length; i++)
            dice[i] = new Dice();

        for (int i = 0; i < times; i++) {
            int sum = 0;
            for (int j = 0; j < dice.length; j++)
                sum += dice[j].roll();

            count[sum]++;
        }

        double[] p = new double[count.length];
        for (int i = 0; i < p.length; i++)
            p[i] = (double) count[i] / times;

        return p;
    }

}
