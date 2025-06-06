package dataDance;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/5/10 22:55
 */
public class Leetcode121 {

    public int maxProfit(int[] prices){

        int res = 0;
        int min = Integer.MAX_VALUE;

        for (int num: prices){
            min = Math.min(min, num);
            res = Math.max(res,num-min);
        }
        return res;
    }
}
