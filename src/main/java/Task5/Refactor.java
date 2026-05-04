package Task5;

public class Refactor {
    public static int caughtSpeeding(int speed, boolean isBirthday) {
        int allowance = isBirthday ? 5 : 0;

        if (speed <= 60 + allowance) {
            return 0;
        } else if (speed <= 80 + allowance) {
            return 1;
        } else {
            return 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(caughtSpeeding(60, false));
        System.out.println(caughtSpeeding(65, false));
        System.out.println(caughtSpeeding(85, false));
        System.out.println(caughtSpeeding(65, true));
        System.out.println(caughtSpeeding(85, true));
    }
}
