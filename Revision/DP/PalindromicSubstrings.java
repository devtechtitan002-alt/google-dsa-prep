package Revision.DP;
import java.util.List;
import java.util.ArrayList;

public class PalindromicSubstrings {
    static class Solution {
    public int countSubstrings(String s) {

        int n = s.length();

    boolean[][] dp = new boolean[n][n];


    int count = 0;

    for(int l = n-1; l >= 0; l--) {
        for(int r = l; r < n; r++) {

            if(s.charAt(l)!=s.charAt(r)) {
                dp[l][r] = false;
            }
            else if(r-l <= 1){
                dp[l][r] = true;
            }else{
                dp[l][r] = dp[l+1][r-1];
            }

            if(dp[l][r]) {
              count++;
            }

        }
    }

    return count;

    }
    }


    /*
    class Solution {

    public int countSubstrings(String s) {

        int count = 0;

        for (int start = 0; start < s.length(); start++) {

            for (int end = start; end < s.length(); end++) {

                if (isPalindrome(s, start, end)) {
                    count++;
                }
            }
        }

        return count;
    }

    boolean isPalindrome(String s, int l, int r) {

        if (l >= r) {
            return true;
        }

        if (s.charAt(l) != s.charAt(r)) {
            return false;
        }

        return isPalindrome(s, l + 1, r - 1);
    }
}
     */


private int expand(String s, int l, int r){

    int count = 0;

    while(l >= 0 &&
          r < s.length() &&
          s.charAt(l) == s.charAt(r)){

        count++;

        l--;
        r++;
    }

    return count;
}

public int countSubstrings(String s) {

       int count = 0;

for(int i = 0; i < s.length(); i++){

    count += expand(s, i, i);     // odd
    count += expand(s, i, i + 1); // even
}

return count;
    }


    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.countSubstrings("abc"));
    }
}
