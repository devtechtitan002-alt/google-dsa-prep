package Revision.Math;

public class NumberofCommonFactors {
    static class Solution {
    public int commonFactors(int a, int b) {

        // getting GCD

        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
 
        int gcd = a,count=0;

        // Getting no of factors of GCD
        
       for(int i = 1; i * i <= gcd; i++) {

    if(gcd % i == 0) {

        if(i == gcd / i) {
            count++;
        } else {
            count += 2;
        }
    }
}

        return count;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.commonFactors(18,12));
    }
}
