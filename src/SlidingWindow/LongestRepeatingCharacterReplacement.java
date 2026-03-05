public class LongestRepeatingCharacterReplacement {
    static class Solution {
       public int characterReplacement(String s, int k) {
          int maxLen=0,left=0,maxFreq=0,windowSize=0;
          int[] freqArr = new int[26];
          for(int right=0;right<s.length();right++){
             char ch = s.charAt(right);
             freqArr[ch-'A']++;
             maxFreq = Math.max(maxFreq,freqArr[ch-'A']);
             while( (((right-left)+1)-maxFreq) > k){
               freqArr[s.charAt(left)-'A']--;
               left++;
               // for(int i=0;i<26;i++) {
                //     maxFreq=Math.max(freq[i],maxFreq);
                // }
             }
             maxLen=Math.max(maxLen,(right-left)+1);
          }
          return maxLen;
       }
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.characterReplacement("ABAB", 2));
        System.out.println(sol.characterReplacement("AABABBA", 1));
    }
}
