package layOffDays.FastSlowPointers;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/9/17 22:14
 */
public class HappyNumber_202 {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        while (true) {
            if (fast == 1 || helper(fast) == 1)
                return true;
            slow = helper(slow);
            fast = helper(helper(fast));
            if (slow == fast)
                return false;
        }

    }

    public static int helper(int num) {
        String s = Integer.toString(num);
        int res = 0;
        for (int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            int tmp = c-'0';
            res += tmp*tmp;
        }
        return res;
    }
}
