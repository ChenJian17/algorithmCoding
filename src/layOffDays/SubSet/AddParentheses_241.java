package layOffDays.SubSet;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/7/6 23:19
 */
public class AddParentheses_241 {

    char[] array;
    public List<Integer> diffWaysToCompute(String expression) {
        array = expression.toCharArray();
        return dfs(0, array.length-1);
    }

    private List<Integer> dfs(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i<= right; i++) {
            if (array[i] >= '0' && array[i] <= '9')
                continue;
            List<Integer> leftNum = dfs(left,i-1);
            List<Integer> rightNum = dfs(i+1,right);

            for (int a : leftNum) {
                for (int b : rightNum){
                    int cur = 0;
                    if (array[i] == '*')
                        cur = a*b;
                    else if (array[i] == '+')
                        cur = a+b;
                    else if (array[i] == '-')
                        cur = a-b;

                    res.add(cur);
                }
            }
        }

        if (res.isEmpty()) {
            int cur = 0;
            int i = left;
            while (i<=right) {
                cur = cur*10+(array[i]-'0');
                i++;
            }
            res.add(cur);
        }
        return res;
    }
}
