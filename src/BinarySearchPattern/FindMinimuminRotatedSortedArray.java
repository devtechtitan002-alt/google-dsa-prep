public class FindMinimuminRotatedSortedArray {
    static class Solution {
    public int findMin(int[] nums) {
        int min=Integer.MAX_VALUE;
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+((right-left)/2);
            if(nums[mid]<=nums[right]){
                min=Math.min(min,nums[mid]);
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return min==Integer.MAX_VALUE?nums[0]:min;
        /*
        int left = 0, right = nums.length-1;
        while(left < right){               // < not <= one element left that could be the answer so
        int mid = left+(right-left)/2;
        if(nums[mid] > nums[right]) left = mid+1;
        else right = mid;              // mid could be answer
        }
        return nums[left];   //left always point to min element 
        */
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.findMin(new int[]{3,4,5,1,2}));
        System.out.println(sol.findMin(new int[]{3,4,5,6,7,0,1,2}));
        System.out.println(sol.findMin(new int[]{11,13,15,17}));
        System.out.println(sol.findMin(new int[]{2,1}));
        System.out.println(sol.findMin(new int[]{8,4,6,7}));
    }
}
}
