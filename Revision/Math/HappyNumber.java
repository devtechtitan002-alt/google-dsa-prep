package Revision.Math;
import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    static class Solution {

    public int getNextNum(int n) {
    int sum = 0;

    while(n > 0) {
        int digit = n % 10;
        sum += digit * digit;
        n /= 10;
    }

    return sum;
}

public boolean isHappy(int n) {

    Set<Integer> seen = new HashSet<>();

    while(true) {

        if(n == 1) {
            return true;
        }

        if(seen.contains(n)) {
            return false;
        }

        seen.add(n);

        n = getNextNum(n);
    }
    
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.isHappy(19));
    }
}
