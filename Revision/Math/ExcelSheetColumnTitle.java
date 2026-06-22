package Revision.Math;

public class ExcelSheetColumnTitle {
    static class Solution {
    public String convertToTitle(int columnNumber) {

        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {

            columnNumber--;

            sb.append((char) ('A' + columnNumber % 26));

            columnNumber /= 26;
        }

        return sb.reverse().toString();
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.convertToTitle(731));
    }
}
