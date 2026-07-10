package dsaRepetition.July_9;
import java.util.Map;
import java.util.HashMap;

public class ContiguousArray {
    static class Solution {
    public int findMaxLength(int[] nums) {

        int maxLen=0,prefixZero=0,prefixOne=0;
        Map<Integer,Integer> balanceVsIndex = new HashMap<>();
        balanceVsIndex.put(0,-1);

        for(int i=0;i<nums.length;i++){
            
            if(nums[i] == 0){
                prefixZero++;
            }else{
                prefixOne++;
            }

            int balance = prefixZero-prefixOne;

            if(balanceVsIndex.containsKey(balance)){
                maxLen = Math.max(maxLen,i-balanceVsIndex.get(balance));
                continue;
            }

            balanceVsIndex.put(balance,i);
        }

        return maxLen;
    }
    }


}
