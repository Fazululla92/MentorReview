package Task5;

public class MakeChocolate {

    public static int makeChocolate(int small, int big, int goal) {
        int maxBigBarsWeCanUse = goal/5;
        int bigBarsToUse = Math.min(big, maxBigBarsWeCanUse);

        int remaining = goal - (bigBarsToUse * 5);

        if (remaining <= small) {
            return remaining;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(makeChocolate(4, 1, 9));
        System.out.println(makeChocolate(4, 1, 10));
        System.out.println(makeChocolate(4, 1, 7));
    }
}
