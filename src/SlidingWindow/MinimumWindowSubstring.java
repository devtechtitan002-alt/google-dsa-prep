import java.util.HashMap;
public class MinimumWindowSubstring {
    static class Solution {
    public String minWindow(String s, String t) {
        int count=0,left=0,minLen=Integer.MAX_VALUE;
        String resStr="";
        HashMap<Character,Integer> sMap = new HashMap<>();
        HashMap<Character,Integer> tMap = new HashMap<>();
        for(char ch : t.toCharArray()){
          tMap.put(ch,tMap.getOrDefault(ch,0)+1);
        }
        for(int right=0;right<s.length();right++){
           char ch = s.charAt(right);
           sMap.put(ch,sMap.getOrDefault(ch,0)+1);
            if(tMap.containsKey(ch) && sMap.get(ch)<=tMap.get(ch)){
              count++;
            }
            while(count==t.length()){
               // update min FIRST before shrinking
               if((right - left + 1) < minLen){
                  minLen = right - left + 1;
                  resStr = s.substring(left, right+1);
               }
              // then shrink
              char chLeft = s.charAt(left);
              if(tMap.containsKey(chLeft) && sMap.get(chLeft) <= tMap.get(chLeft)){
                  count--;
              }
              sMap.put(chLeft, sMap.get(chLeft)-1);
              left++;
            }
        }
        return resStr;
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.minWindow("ADOBECODEBANC", "ABC"));
    }
}
}
