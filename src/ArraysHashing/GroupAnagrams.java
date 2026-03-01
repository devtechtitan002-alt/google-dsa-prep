package ArraysHashing;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class GroupAnagrams {
    static  class Solution {
    public String getFreqKey(String word) {
    int[] freqArr = new int[26];
       for (char ch : word.toCharArray()) {
         freqArr[ch - 'a']++;
       }

       StringBuilder sb = new StringBuilder();
       for (int freq : freqArr) {
          sb.append(freq).append('#');
       }
      return sb.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> groupWords = new HashMap<>();
        for(String word : strs){
            String sortedWord = getFreqKey(word);
            if(groupWords.containsKey(sortedWord)){
               groupWords.get(sortedWord).add(word);
            }else{
               groupWords.put(sortedWord,new ArrayList<>(Arrays.asList(word)));
            }
        }
        return new ArrayList<>(groupWords.values());
    }
}

    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.groupAnagrams(new String[]{"bdddddddddd","bbbbbbbbbbc"}));
    }
}
