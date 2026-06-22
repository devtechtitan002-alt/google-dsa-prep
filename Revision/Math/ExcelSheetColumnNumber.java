package Revision.Math;

public class ExcelSheetColumnNumber {
     static class Solution {
    public int titleToNumber(String columnTitle) {
        int answer = 0;

        char[] rev = columnTitle.toCharArray();

        int time = 1;
        for(int i=rev.length-1;i>=0;i--){
            int num = (rev[i]-'A')+1;
            answer += time*num;
            time *= 26;
        }

        return answer;
    }

    /*
    public int titleToNumber(String columnTitle) {

    int ans = 0;

    for(char ch : columnTitle.toCharArray()) {
        ans = ans * 26 + (ch - 'A' + 1);
    }

    return ans;
}
     */
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.titleToNumber("AB"));
    }
}
