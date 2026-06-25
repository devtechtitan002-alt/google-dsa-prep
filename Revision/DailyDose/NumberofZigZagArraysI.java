package Revision.DailyDose;

public class NumberofZigZagArraysI {
    static class Solution {

    public int recurse(int prev1,int prev2,int count,int n,int l,int r){

        // base case 
        if(count == n) return 1;

        int sum = 0;

        for(int i=l;i<=r;i++){

            int curr = i;
           
            // prev1 setter
            if(count == 0){

                if(prev2 == curr) continue;   // condition 1

                prev1 = curr;

                if(count >= 2){

                   if( ( (prev1 < prev2) && (prev2 < curr) ) || ( (prev1 > prev2) && (prev2 > curr) ) ) continue;

                   sum += recurse(prev2,curr,count+1,n,l,r);

                }else{

                   sum += recurse(prev1,prev2,count+1,n,l,r);

                }
                
            }


            // prev2 setter
            if(count == 1){

                if(prev1 == curr) continue;   // condition 1

                prev2 = curr;

                if(count >= 2){

                     if( ( (prev1 < prev2) && (prev2 < curr) ) || ( (prev1 > prev2) && (prev2 > curr) ) ) continue;

                     sum += recurse(prev2,curr,count+1,n,l,r);

                }else{

                   sum += recurse(prev1,prev2,count+1,n,l,r);

                }
                
            }

        }

        return sum;
    }

    public int zigZagArrays(int n, int l, int r) {
        return recurse(-1,-1,0,n,l,r);
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.zigZagArrays(3,4,5));
    }
}
