package Revision.Math;

public class NimGame {
    static class Solution {
    public boolean recurse(int player,int n){
        if(n%4 != 0) return player == 1 ? true : false;
        int playerNext = player == 1 ? 2 : 1;
        boolean one = recurse(playerNext,n-1);
        boolean two = recurse(playerNext,n-2);
        boolean three = recurse(playerNext,n-3);
        boolean canWin = one || two || three;
        return canWin;
    }
    public boolean canWinNim(int n) {
        return recurse(1,n);
    }

    // return n%4 != 0
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.canWinNim(8));
    }
}
