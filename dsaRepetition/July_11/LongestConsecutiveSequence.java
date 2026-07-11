package dsaRepetition.July_11;
import java.util.Set;
import java.util.HashSet;
public class LongestConsecutiveSequence {
    class Solution{
        public int longestConsecutive(int[] nums) {

            Set<Integer> set = new HashSet<>();

            for(int num : nums){
                set.add(num);
            }

            int maxLen=0;

            for(int number : set){
                if(!set.contains(number-1)){
                    int temp = number;
                    int len = 0;
                    while(set.contains(temp)){
                        len++;
                        temp--;
                    }
                    maxLen = Math.max(maxLen,len);
                }
            }

            return maxLen;
        }
    }
}
