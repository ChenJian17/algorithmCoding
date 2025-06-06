package contest;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/5/18 11:15
 */
public class Solution1 {

    public int smallestIndex(int[] nums) {
        for (int i = 0; i<nums.length; i++){
            if (fun(nums[i],i)){
                return i;
            }
        }
        return -1;

    }


    public boolean fun(int num, int index){
        int res = 0;
        while (num != 0){
            int tmp = num%10;
            num = num/10;
            res += tmp;
        }

        return res == index;

    }

}
