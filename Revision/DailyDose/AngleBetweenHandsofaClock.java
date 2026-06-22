package Revision.DailyDose;

public class AngleBetweenHandsofaClock {
    static class Solution {
    public double angleClock(int hour, int minutes) {
         double H = hour;
         double M = minutes;
         double angle = Math.abs(30 * H - 5.5 * M) % 360;
         return Math.min(angle, 360 - angle);
    }
    }

    public static void main(String[] argsas){
        Solution sol = new Solution();
        System.out.println(sol.angleClock(12,30));
        System.out.println(sol.angleClock(3,30));
        System.out.println(sol.angleClock(3,15));
        System.out.println(sol.angleClock(1,57));
        System.out.println(sol.angleClock(4,50));

    }
}
