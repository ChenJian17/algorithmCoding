package layOffDays.SubSet;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/7/6 20:14
 */
public class GeneralizedAbbreviation_320 {

    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> generalizedAbbreviation(String word) {
        char[] array = word.toCharArray();
        dfs(array, 0, 0);
        return res;

    }

    // DFS递归树，数组里的每个字符每次都有两种选择，变为数字1还是不变
    // 如果变为数字1，需要将前面累计的num加起来
    private void dfs(char[] array, int index, int num){
        int len = sb.length();
        // base case
        if (index == array.length) {
            if (num > 0){
                sb.append(num);
            }
            res.add(sb.toString());
        }else {
            // 1.变为数字
            dfs(array, index+1, num+1);
            if (num > 0){
                sb.append(num);
            }
            sb.append(array[index]);
            // 2.保持为字母不变
            dfs(array, index+1, 0);
        }
        sb.setLength(len);

    }
}
