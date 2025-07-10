package top150;

import java.util.Arrays;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/7/10 20:17
 */
public class Candy {
    public int candy(int[] ratings) {

        int[] left = new int[ratings.length];
        Arrays.fill(left,1);
        for(int i = 1; i<ratings.length; i++){
            if(ratings[i] > ratings[i-1]){
                left[i] = left[i-1]+1;
            }
        }

        int[] right = new int[ratings.length];
        Arrays.fill(right,1);
        for(int i = ratings.length-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                right[i] = right[i+1]+1;
            }
        }

        int count = 0;
        for(int i = 0; i<ratings.length; i++){
            count += Math.max(left[i], right[i]);
        }
        return count;
    }
}
