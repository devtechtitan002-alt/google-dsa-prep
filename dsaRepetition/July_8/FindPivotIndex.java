package dsaRepetition.July_8;

public class FindPivotIndex {
    static class Solution {

    /*
    public int pivotIndex(int[] nums) {

        int n = nums.length,pivot=-1;
        int[] temp1  = new int[n];
        int[] temp2 = new int[n];

        temp1[0] = nums[0];
        for(int i=1;i<n;i++){
           temp1[i] = temp1[i-1] + nums[i];
        }

        temp2[n-1] =  nums[n-1];
        if(temp1[n-1] == temp2[n-1]){
            pivot = n-1;
        }
        for(int i=n-2;i>=0;i--){

            temp2[i] = temp2[i+1] + nums[i];

            if(temp1[i] == temp2[i]){
                pivot = i;
            }
        }

        return pivot;
    }
    */

    public int pivotIndex(int[] nums) {

        int n = nums.length;
int pivotIndex = -1;

// Prefix sum
for (int i = 1; i < n; i++) {
    nums[i] += nums[i - 1];
}

int rightSum = 0;

for (int i = n - 1; i >= 0; i--) {

    if (i < n - 1) {
        rightSum += nums[i + 1] - nums[i];
    }

    int leftSum = (i == 0) ? 0 : nums[i - 1];

    if (leftSum == rightSum) {
        pivotIndex = i;
    }
}

return pivotIndex;

    }
    }

    // standard approach by AI

    /*
    class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
    int rightSum = Arrays.stream(nums).sum();

    for (int i = 0; i < nums.length; i++) {
        leftSum += nums[i];
        if (leftSum == rightSum) {
            return i;
        }
        
        rightSum -= nums[i];
    }

    return -1;
    }
} */

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.pivotIndex(new int[]{1,7,3,6,5,6}));
    }
}
