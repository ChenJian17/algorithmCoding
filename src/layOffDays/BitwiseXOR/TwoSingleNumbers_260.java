package layOffDays.BitwiseXOR;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/7/23 21:36
 */
public class TwoSingleNumbers_260 {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num: nums) {
            xor ^= num;
        }

        int mask = xor & (-xor);
        int[] arr = new int[2];
        for (int num: nums) {
            if ((mask & num) == 0) {
                arr[0] ^= num;
            }else {
                arr[1] ^= num;
            }
        }
        return arr;

    }
}
