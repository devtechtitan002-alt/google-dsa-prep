package Revision.Math;

import java.util.Arrays;

public class CountPrime {
    static class Solution {
    public int countPrimes(int n) {
        if(n <= 2) return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2;i<n;i++){
            if(isPrime[i]){
               for(int j=i*i;j<n;j+=i){
                 isPrime[j] = false; 
               }
            }
        }

        int count = 0;
        
        for(int i=2;i<n;i++){
            if(isPrime[i]) count++;
        }

        return count;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.countPrimes(20));
    }

}
