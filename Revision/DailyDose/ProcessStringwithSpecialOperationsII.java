package Revision.DailyDose;

public class ProcessStringwithSpecialOperationsII {
    class Solution {
    public char processStr(String s, long k) {

        char ans = '.';

        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()){

            switch(ch){

                case '*' :
                    if(!sb.isEmpty()){
                        sb.deleteCharAt(sb.length()-1);
                        if(Long.valueOf(sb.length()) >= k) ans = sb.charAt(sb.length());
                    }
                    break;
                
                case '#' :
                    if(!sb.isEmpty()){
                        sb.append(sb.toString());
                        if(Long.valueOf(sb.length()) == k) ans = sb.charAt(sb.length());
                    }
                    break;

                case '%' :
                    if(!sb.isEmpty()){
                        sb.reverse();
                        if(Long.valueOf(sb.length()) == k) ans = sb.charAt(sb.length());
                    }
                    break;

                default :
                    sb.append(ch);
            }
        }

        return ans;
    }
}
}
