package Revision.DailyDose;
import java.util.PriorityQueue;

public class MaximumIceCreamBars {
     static class Solution {
    public int maxIceCream(int[] costs, int coins) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));

        for(int cost : costs){
           coins -= cost;
           pq.add(cost);

           if(coins <0 ){
              coins += pq.poll();
           }
        }
        return pq.size();
    }

    /*
    
    class Solution {
    public int maxIceCream(int[] costs, int coins) {

        int[] freq = new int[100001];

        for(int cost : costs){
            freq[cost]++;
        }

        int count = 0;

        for(int cost = 1; cost <= 100000; cost++){

            if(freq[cost] == 0) continue;

            int canBuy = Math.min(freq[cost], coins / cost);

            count += canBuy;
            coins -= canBuy * cost;

            if(coins < cost){
                break;
            }
        }

        return count;
    }
}
    */
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.maxIceCream(new int[]{1,6,3,1,2,5},20));
    }
}
