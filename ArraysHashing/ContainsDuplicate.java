import java.util.Arrays;
public class ContainsDuplicate{
    static class Solution{
       public boolean containsDuplicate(int[] nums) {
          Arrays.sort(nums);
          for(int i=1;i<nums.length;i++){
             if(nums[i-1]==nums[i]){
                return true;
             }
          }
          return false;
         //  HashSet<Integer> seen = new HashSet<>();
         //  for(int i=0;i<nums.length;i++){
         //    if(!seen.add(nums[i])){ return true;}
         //  }
         //  return false;
       }
    }
    public static void main(String args[]){
        Solution sol = new Solution();

        System.out.println(sol.containsDuplicate(new int[]{1,2,3,1}));

        System.out.println(sol.containsDuplicate(new int[]{1,2,3,4}));

        System.out.println(sol.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }
}