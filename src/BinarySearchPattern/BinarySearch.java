public class BinarySearch {
    static class Solution {
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2; 
            int currNum=nums[mid];
            if(currNum==target){ return mid; }
            else if(currNum<target){ left=mid+1; }
            else{ right=mid-1; }
        }
        return -1;
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.search(new int[]{-1,0,3,5,9,12},9));
        System.out.println(sol.search(new int[]{-1,0,3,5,9,12},2));

    }
}
}
