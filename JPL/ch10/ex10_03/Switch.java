package ch10.ex10_03;

public class Switch {

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

        switch (day) {
        case SATURDAY:
            return false;

        case SUNDAY:
            return false;

        default:
            return true;
        }

    }

}
