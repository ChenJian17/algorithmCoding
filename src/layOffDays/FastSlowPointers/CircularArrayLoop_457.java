package layOffDays.FastSlowPointers;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/9/24 23:23
 */
public class CircularArrayLoop_457 {
    int[] nums;
    int n;
    public boolean circularArrayLoop(int[] nums) {
        n = nums.length;
        this.nums = nums;

        for (int i = 0; i < n; i++) {
            int slow = i, fast = next(i);
            while (nums[slow]*nums[fast] > 0 && nums[slow]*nums[next(fast)] > 0) {
                if (slow == fast) {
                    if (slow == next(slow)) break;
                    else return true;
                }
                slow = next(slow);
                fast = next(next(fast));
            }
        }
        return false;

    }

    private int next(int index) {
        return ((index + nums[index]) % n + n) % n;
    }
}
