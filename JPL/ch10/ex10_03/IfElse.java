package ch10.ex10_03;

public class IfElse {

    public static void main(String[] args) {

        Day day;

        day = Day.MONDAY;
        System.out.println(day + ": " + isWorkday(day));

        day = Day.TUESDAY;
        System.out.println(day + ": " + isWorkday(day));

        day = Day.WEDNESDAY;
        System.out.println(day + ": " + isWorkday(day));

        day = Day.THURSDAY;
        System.out.println(day + ": " + isWorkday(day));

        day = Day.FRIDAY;
        System.out.println(day + ": " + isWorkday(day));

        day = Day.SATURDAY;
        System.out.println(day + ": " + isWorkday(day));

        day = Day.SUNDAY;
        System.out.println(day + ": " + isWorkday(day));
    }

    public static boolean isWorkday(Day day) {

        if (day == Day.SATURDAY) {
            return false;
        } else if (day == Day.SUNDAY) {
            return false;
        } else {
            return true;
        }
    }

}
