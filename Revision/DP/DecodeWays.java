package Revision.DP;
import java.util.Arrays;

public class DecodeWays {
    static class Solution{


        /*

        // Recursion

        public int recurse(int idx,String s){
            if(idx >= s.length()) return 1;

            int oneDigit=0,twoDigit=0;
                
            // single digit
            if(Integer.valueOf(s.charAt(idx)-'0') != 0){
                oneDigit = recurse(idx+1,s);
            }

            // double digit
            if(idx<s.length()-1 && Integer.valueOf(s.substring(idx,idx+2)) >= 10 && Integer.valueOf(s.substring(idx,idx+2)) <= 26){
                twoDigit = recurse(idx+2,s);
            } 

            return oneDigit+twoDigit;
        }

        public int numDecodings(String s) {
           return recurse(0,s);
        }

        */


        /*

        // Memo 

        public int recurse(int idx,String s,int[] dp){

            if(idx >= s.length()) return 1;

            if(dp[idx] != -1) return dp[idx];

            int oneDigit=0,twoDigit=0;
                
            // single digit
            if(Integer.valueOf(s.charAt(idx)-'0') != 0){
                oneDigit = recurse(idx+1,s,dp);
            }

            // double digit
            if(idx<s.length()-1 && Integer.valueOf(s.substring(idx,idx+2)) >= 10 && Integer.valueOf(s.substring(idx,idx+2)) <= 26){
                twoDigit = recurse(idx+2,s,dp);
            } 

            return dp[idx] = oneDigit+twoDigit;

        }

        public int numDecodings(String s) {

           int[] dp = new int[s.length()+1];
           Arrays.fill(dp,-1);
           return recurse(0,s,dp);

        }

        */


        /*
        
        // Bottom Up 

        public int numDecodings(String s) {

           int[] dp = new int[s.length()+1];

           // Base Case
           dp[s.length()] = 1;

           for(int i=s.length()-1;i>=0;i--){
              
                if(Integer.valueOf(s.charAt(i)-'0') != 0){
                    dp[i] += dp[i+1];
                }

                if(i<s.length()-1 && Integer.valueOf(s.substring(i,i+2)) >= 10 && Integer.valueOf(s.substring(i,i+2)) <= 26){
                    dp[i] += dp[i+2];
                }
           }

           return dp[0];
           
        }

        */

        // O(1) - Space

        public int numDecodings(String s) {

           // Base Case
           int temp1 = 1,temp2=1;

           for(int i=s.length()-1;i>=0;i--){
              
                int ans = 0;

                if(Integer.valueOf(s.charAt(i)-'0') != 0){
                    ans += temp1;
                }

                if(i<s.length()-1 && Integer.valueOf(s.substring(i,i+2)) >= 10 && Integer.valueOf(s.substring(i,i+2)) <= 26){
                    ans += temp2;
                }

                int temp = temp1;
                temp1 = ans;
                temp2 = temp;

           }


           return temp1;
           
        }


    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.numDecodings("11106"));
    }

}
