package top100.greedy;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/5/2 21:59
 */
public class BestTime {

    public int maxProfit(int[] prices) {

        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices){
            cost = Math.min(price,cost);
            profit = Math.max(profit,price-cost);
        }
        return profit;


    }
}
