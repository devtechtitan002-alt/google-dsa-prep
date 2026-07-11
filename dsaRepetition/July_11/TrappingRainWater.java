package dsaRepetition.July_11;

public class TrappingRainWater {
    static class Solution{
        public int trap(int[] height) {
            int n = height.length,trappedWater=0;
            int lMax=height[0],rMax=height[n-1],l=0,r=n-1;

            while(l<=r){
                
                if(height[l] < height[r]){
                    
                    lMax = Math.max(lMax,height[l]);
                    int water = lMax-height[l];
                    if(water > 0) trappedWater += water;
                    l++;

                }else{
                    
                    rMax = Math.max(rMax,height[r]);
                    int water = rMax-height[r];
                    if(water > 0) trappedWater += water;
                    r--;

                }

            }

            return trappedWater;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.trap(new int[]{4,2,0,3,2,5}));
    }
}
