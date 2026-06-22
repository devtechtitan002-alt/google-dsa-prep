package Revision.DailyDose;

public class ProcessStringwithSpecialOperationsI {

    static class Solution {
    public String processStr(String s) {

        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()){

            switch(ch){

                case '*' :
                    if(!sb.isEmpty()){
                        sb.deleteCharAt(sb.length()-1);
                    }
                    break;
                
                case '#' :
                    if(!sb.isEmpty()){
                        sb.append(sb.toString());
                    }
                    break;

                case '%' :
                    if(!sb.isEmpty()){
                        sb.reverse();
                    }
                    break;

                default :
                    sb.append(ch);
            }
        }

        return sb.toString();
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution(); 
        System.out.println(sol.processStr("z*#"));
    }
}
