package Revision.Contests;
import java.util.Arrays;

public class P1 {

   static  class Solution {

    public boolean recurse(int r,int c,int row,int col,String[][] ans){
        if(r == row-1 && c == col-1) {
            ans[r][c] = ".";
            return true;
        }
        if(r<0 || c<0 || r>=row || c>=col) return false;

        ans[r][c] = ".";
        boolean right = recurse(r,c+1,row,col,ans);
        if(right) return true;
        boolean down = recurse(r+1,c,row,col,ans);
        if(down) return true;
        return true;
    }
    public String[] createGrid(int m, int n) {
        String[][] ans = new String[m][n];
        for(String[] tmp : ans){
            Arrays.fill(tmp,"#");
        }
        recurse(0,0,m,n,ans);
        String[] result = new String[m];
        int i=0;
            for(String[] s : ans){
                StringBuilder sb = new StringBuilder();
                for(String ss : s){ sb.append(ss); }
                result[i++] = sb.toString();
            }
        
        return result;
    }
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.createGrid(2,3)));
    }
}
