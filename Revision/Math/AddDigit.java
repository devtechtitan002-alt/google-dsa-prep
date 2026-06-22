package Revision.Math;

public class AddDigit {
    static class Solution {

    public int getSum(int n){
        int sum = 0;

        while(n > 0){
           sum += n%10;
           n /= 10;
        }

        return sum;
    }
    public int addDigits(int num) {

        while(num%10 != num){
            num = getSum(num);
        }

        return num;
    }
    
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.addDigits(11));
    }
}
