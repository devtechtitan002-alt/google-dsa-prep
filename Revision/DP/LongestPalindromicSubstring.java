package Revision.DP;

public class LongestPalindromicSubstring {
    static class Solution{
        public String longestPalindrome(String s) {

            int start=0,maxLen=0;

            for(int i=0;i<s.length();i++){

                int l=i,r=i;

                while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                    l--;
                    r++;
                }

                int currLen = (r-l)-1;
                if( currLen > maxLen ){
                    start = l+1;
                    maxLen = currLen;
                }

                l=i;
                r=i+1;

                if(r < s.length()){

                    while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                        l--;
                        r++;
                    }

                    currLen = (r-l)-1;
                    if( currLen > maxLen ){
                    start = l+1;
                    maxLen = currLen;
                }

                }

               
            }

            return s.substring(start,start+maxLen);
        }


        /*
        class Solution {

    public String longestPalindrome(String s) {

        String ans = "";

        for (int i = 0; i < s.length(); i++) {

            for (int j = i; j < s.length(); j++) {

                if (isPalindrome(s, i, j)) {

                    if (j - i + 1 > ans.length()) {
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }

        return ans;
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
} */
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.longestPalindrome("abcba"));
    }
}
