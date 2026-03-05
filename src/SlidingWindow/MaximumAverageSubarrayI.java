public class MaximumAverageSubarrayI {
    static class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum=0,currAvg=0,maxAvg=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        currAvg = sum/k;
        maxAvg = currAvg;
        for(int i=k;i<nums.length;i++){
            sum += nums[i]-nums[i-k];
            currAvg = sum/k;
            maxAvg = Math.max(currAvg,maxAvg);
        }
        return maxAvg;
        /*
        Set<Integer> set = new HashSet<>();

        int left = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int right = 0; right < nums.length; right++) {
            set.add(nums[right]);
            sum += nums[right];

            // Maintain window size k
            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, sum);

                // Remove left element
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
        }

        return (double) maxSum / k;
        */
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
    }
}
}
