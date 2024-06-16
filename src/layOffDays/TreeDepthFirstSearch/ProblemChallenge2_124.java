package layOffDays.TreeDepthFirstSearch;

import com.chenjian.cn.util.TreeNode;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/4/5 23:25
 */
public class ProblemChallenge2_124 {

    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

   // 返回当前节点能为父亲提供的贡献
    public int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(res, left+right+root.val);

        int max = Math.max(root.val+left, root.val+right);
        return max<0 ? 0 : max;

    }

    // 该节点作为起始节点时最大贡献
    public int dfs2(TreeNode root) {
        if (root == null)
            return 0;

        int left = Math.max(dfs(root.left),0);
        int right = Math.max(dfs(root.right),0);

        res = Math.max(res, root.val+left+right);

        return Math.max(root.val+left,root.val+right);
    }
}
