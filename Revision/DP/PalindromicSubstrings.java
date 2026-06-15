package Revision.DP;
import java.util.List;
import java.util.ArrayList;

public class PalindromicSubstrings {
    static class Solution {
    public int countSubstrings(String s) {

        int count=0;

        for(int i=0;i<s.length();i++){
             
                // odd length palindromes
                int l=i,r=i;

                while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                    count++;
                    l--;
                    r++;
                }

                // even length palindromes
                l = i;
                r = i + 1;

                if(r < s.length()){

                    while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                        count++;
                        l--;
                        r++;
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

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.countSubstrings("abc"));
    }
}
