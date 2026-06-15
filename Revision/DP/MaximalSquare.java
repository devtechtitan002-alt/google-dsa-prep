package Revision.DP;

public class MaximalSquare {
    static class Solution {

    public int recurse(int r,int c,char[][] mat){
        if(r<0 || c<0 || r>=mat.length || c>=mat[0].length) return 0;

        if(mat[r][c] == '0') return 0;

        int right = recurse(r,c+1,mat);
        int down =  recurse(r+1,c,mat);
        int diagonal = recurse(r+1,c+1,mat);
        
        return 1+Math.min(diagonal,Math.min(right,down));
    }

    public int maximalSquare(char[][] matrix) {

        int area = 0;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                area = Math.max(area,recurse(i,j,matrix));
            }
        }

        return area;
    }
}
}
