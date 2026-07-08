package Revision.DailyDose;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class NumberofPathswithMaxScore {
    static class Solution {

    int[][] DIRS = { {-1,0} , {-1,-1} , {0,-1} };

    public int dfs(List<String> board,Integer[][] memo,int r,int c,int row,int col){
        
        if(r == 0 && c == 0){
            return 0;
        }

        if(r < 0 || c < 0 || r >= row || c >= col) return 0;

        if(memo[r][c] != null) return memo[r][c];

        int sum = 0;

        char ch = board.get(r).charAt(c);

        if(ch != 'X'){
            for(int[] dirs : DIRS){
                sum += dfs(board,memo,r+dirs[0],c+dirs[1],row,col);
            }
        }

        int currScore = (ch != 'S' && ch != 'E') ? Integer.valueOf(ch-'0') : 0;

        return  memo[r][c] = currScore + sum;
    }

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int r=n,c=n;
        Integer[][] memo = new Integer[r][c];
        dfs(board,memo,r-1,c-1,r,c);
        for(Integer[] temp : memo){
            System.out.println((Arrays.toString(temp)));
        }
        return null;
    }

    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.pathsWithMaxScore(new ArrayList<String>(List.of("E23","2X2","12S"))));
    }
}
