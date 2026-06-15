package Revision.DP;

public class UniquePaths {
    static class Solution {

    public int recurse(int r,int c,int row,int col){

        if(r == row-1 && c == col-1) return 1;

        if(r >= row || c >= col) return 0;

        int down = recurse(r+1,c,row,col);

        int right = recurse(r,c+1,row,col);

        return down+right;
    }
    public int uniquePaths(int m, int n) {
        return recurse(0,0,m,n);
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.uniquePaths(3,7));
    }
}
