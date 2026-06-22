package Revision.DP;

public class LongestPalindromicSubstring {
    static class Solution{

        // recursion

        /*
        public String longestPalindrome(String s) {

    int n = s.length();

    int start = 0;
    int maxLen = 1;

    for(int l = 0; l < n; l++) {
        for(int r = l; r < n; r++) {

            if(isPalindrome(l, r, s)) {

                int len = r - l + 1;

                if(len > maxLen) {
                    maxLen = len;
                    start = l;
                }
            }
        }
    }

    return s.substring(start, start + maxLen);
}

private boolean isPalindrome(
        int l,
        int r,
        String s) {

    if(l >= r) return true;

    if(s.charAt(l) != s.charAt(r))
        return false;

    return isPalindrome(l + 1, r - 1, s);
}

*/
         
    /*

    // Memo

        public String longestPalindrome(String s) {

    int n = s.length();

    Boolean[][] memo = new Boolean[n][n];

    int start = 0;
    int maxLen = 1;

    for(int l = 0; l < n; l++) {
        for(int r = l; r < n; r++) {

            if(isPalindrome(l, r, s, memo)) {

                int len = r - l + 1;

                if(len > maxLen) {
                    maxLen = len;
                    start = l;
                }
            }
        }
    }

    return s.substring(start, start + maxLen);
}

private boolean isPalindrome(
        int l,
        int r,
        String s,
        Boolean[][] memo) {

    if(l >= r) return true;

    if(memo[l][r] != null)
        return memo[l][r];

    if(s.charAt(l) != s.charAt(r))
        return memo[l][r] = false;

    return memo[l][r]
            = isPalindrome(l + 1, r - 1, s, memo);
}

*/


        public String longestPalindrome(String s) {

    int n = s.length();

    boolean[][] dp = new boolean[n][n];


    int start = 0;
    int maxLen = 1;

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

                int len = r - l + 1;

                if(len > maxLen) {
                    maxLen = len;
                    start = l;
                }
            }

        }
    }

    return s.substring(start, start + maxLen);
}


        /*
        public String longestPalindrome(String s) {

    int start = 0;
    int maxLen = 1;

    for(int i = 0; i < s.length(); i++) {

        // Odd length
        int len1 = expand(s, i, i);

        // Even length
        int len2 = expand(s, i, i + 1);

        int len = Math.max(len1, len2);

        if(len > maxLen) {
            maxLen = len;
            start = i - (len - 1) / 2;
        }
    }

    return s.substring(start, start + maxLen);
}

private int expand(String s, int l, int r) {

    while(l >= 0 && r < s.length()
            && s.charAt(l) == s.charAt(r)) {
        l--;
        r++;
    }

    return r - l - 1;
}
     */
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.longestPalindrome("abcba"));
    }
}
