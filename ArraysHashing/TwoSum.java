package ArraysHashing;
import java.util.Arrays;
import java.util.HashMap;
public class TwoSum{
    static class Solution{
       public int[] twoSum(int[] nums,int target){
        HashMap<Integer,Integer> complementMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int complement = target-nums[i];
            if(complementMap.containsKey(complement)){
               return new int[]{complementMap.get(complement),i};
            }
            complementMap.put(nums[i],i);
        }
        return new int[]{};
       }
    }
    public static void main(String args[]){
        Solution sol = new Solution();

        int[] res1 = sol.twoSum(new int[]{2,7,11,15},9);
        System.out.println(Arrays.toString(res1));

        int[] res2 = sol.twoSum(new int[]{3,2,4},6);
        System.out.println(Arrays.toString(res2));

        int[] res3 = sol.twoSum(new int[]{3,3},6);
        System.out.println(Arrays.toString(res3));
    }
}