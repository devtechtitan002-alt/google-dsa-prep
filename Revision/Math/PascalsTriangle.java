package Revision.Math;

import java.util.List;
import java.util.ArrayList;

public class PascalsTriangle {
    static class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {

            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {

                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(
                        res.get(i - 1).get(j - 1)
                        + res.get(i - 1).get(j)
                    );
                }
            }

            res.add(row);
        }

        return res;
    }
}

    public static void main(String[] args){
        Solution sol = new Solution();
        for(List<Integer> temp : sol.generate(5)){
        System.out.println(temp);
        }
    }
}
