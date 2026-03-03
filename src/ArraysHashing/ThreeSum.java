import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ThreeSum {
    static class Solution{
       public List<List<Integer>> threeSum(int[] nums) {
        int currNum=0,sum=0,left=0,right=0,complement=0;
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> resFinal = new ArrayList<>();
        int[] orig = nums;
        Arrays.sort(nums);
        for(int curr=0;curr<=nums.length-3;curr++){
           currNum = nums[curr];
           complement = ((-1)*currNum);
           left=curr+1;
           right=nums.length-1;
           while(left<right){
              sum=nums[left]+nums[right];
              if( sum == complement ){
                 res.add(orig[curr]);
                 res.add(orig[left]);
                 res.add(orig[right]);
                 break;
              }
              if( sum < complement ){
                right--;
              }else{
                left++;
              }
           }
           if(res!=null){
            resFinal.add(res);
           }
        }
        return resFinal;
       }
    }
    
    public static void main(String args[]){
        Solution sol = new Solution();

        System.out.println(sol.threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(sol.threeSum(new int[]{0,1,1}));
        System.out.println(sol.threeSum(new int[]{0,0,0}));



    }
}
