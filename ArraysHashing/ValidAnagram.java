public class ValidAnagram{
    static class Solution{
       public boolean isAnagram(String s, String t) {
          
        
        if(s.length()!=t.length()) return false;
        /*
          char[] sArr = s.toCharArray();
          char[] tArr = t.toCharArray();
          Arrays.sort(sArr);
          Arrays.sort(tArr);
          return Arrays.equals(sArr,tArr);


          String s1 = new String(sArr);
          String s2 = new String(tArr);
          for(int i=0;i<s1.length();i++){
             if(s1.charAt(i)!=s2.charAt(i)) return false;
          }
          return true;
        */

        //HashMap<Character,Integer> freqMap = new HashMap<>();
        int[] freqArr = new int[26];
        for(int i=0;i<s.length();i++){
            char sCh = s.charAt(i);
            char tCh = t.charAt(i);
            freqArr[sCh-'a']+=1;
            freqArr[tCh-'a']-=1;
        }
        for(int freqOfEachChar : freqArr){
            if(freqOfEachChar != 0) return false;
        }
        return true;
       }
    }
    public static void main(String args[]){
        Solution sol = new Solution();

        System.out.println(sol.isAnagram("anagram", "nagaram"));

        System.out.println(sol.isAnagram("rat", "car"));

    }
}