package Revision.DailyDose;

public class MaximumNumberofBalloons {
    static class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];

        for(char ch : text.toCharArray()){
            freq[ch-'a']++;
        }

        String ans = "ban";
        int min = Integer.MAX_VALUE;

        for(char ch : ans.toCharArray()){
            min = Math.min(min,freq[ch-'a']);
        }

        int min1 = Math.min(freq[11],freq[14]);

        return Math.min(min,min1/2);
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.maxNumberOfBalloons("loonbalxballpoon"));
    }
}
