package layOffDays.BitwiseXOR;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/7/22 21:01
 */
public class SingleNumber_136 {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num: nums) {
            res ^= num;
        }

        return res;
    }
}
