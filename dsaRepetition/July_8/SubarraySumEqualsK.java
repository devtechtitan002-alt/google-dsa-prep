package dsaRepetition.July_8;
import java.util.Map;
import java.util.HashMap;

public class SubarraySumEqualsK {
    static class Solution {

    /*
    public int subarraySum(int[] nums, int k) {

        int sum = 0,ans=0,n=nums.length;

        for(int i=0;i<n;i++){

            sum = nums[i];
            if(k == sum) ans++;

            for(int j=i+1;j<n;j++){

                sum += nums[j];
                if(k == sum) ans++;

            }
        }

        return ans;
    }

    */

     // Optimize approach
     public int subarraySum(int[] nums, int k) {

        Map<Integer,Integer> sumVsFreq = new HashMap<>();
        sumVsFreq.put(0,1);

        int sum = 0,ans=0;
        for(int i=0;i<nums.length;i++){

            sum += nums[i];

            int remainingSum = sum-k;

            if(sumVsFreq.containsKey(remainingSum)){
                ans += sumVsFreq.get(remainingSum);
            }

            sumVsFreq.put(sum,sumVsFreq.getOrDefault(sum,0)+1);
            
        }

        return ans;
    }

    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.subarraySum(new int[]{1,2,3},3));
    }
}
