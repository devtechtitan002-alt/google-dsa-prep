package Revision.DP;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Triangle {
    static class Solution {

    public int recurse(int row,int idx,List<List<Integer>> triangle){
         if(row == triangle.size()-1) return triangle.get(row).get(idx);

         int down = recurse(row+1,idx,triangle);

         int adjacent = recurse(row+1,idx+1,triangle);

         return triangle.get(row).get(idx) + Math.min(down,adjacent);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        return recurse(0,0,triangle);
    }

    }

    public static void main(String[] args){
        Solution sol = new Solution();
        List<List<Integer>> tri = new ArrayList<>();
        tri.add(new ArrayList<>(Arrays.asList(2)));
        tri.add(new ArrayList<>(Arrays.asList(3,4)));
        tri.add(new ArrayList<>(Arrays.asList(6,5,7)));
        tri.add(new ArrayList<>(Arrays.asList(4,1,8,3)));
        System.out.println(sol.minimumTotal(tri));
    }

}
