package layOffDays.TreeDepthFirstSearch;

import com.chenjian.cn.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/4/2 22:41
 */
public class SumRootLeafNumbers_129 {

    public int sumNumbers(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root,res, "");
        int ans = 0;
        for (String num : res) {
            ans += Integer.parseInt(num);
        }
        return ans;

    }

    public void dfs(TreeNode root, List<String> res, String sb) {
        if (root == null)
            return;
        sb += root.val;
        if (root.left == null && root.right == null) {
            res.add(sb);
        }
        dfs(root.left, res, sb);
        dfs(root.right, res, sb);
    }
}
