package layOffDays.TreeDepthFirstSearch;

import com.chenjian.cn.util.TreeNode;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/2/28 21:04
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        return hasPathSum1(root, targetSum);

    }

    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return targetSum == 0;
        }
        if (root.left == null && root.right == null) {
            return (targetSum - root.val) == 0;
        } else {
            return hasPathSum(root.left, targetSum-root.val)
                    || hasPathSum(root.right, targetSum-root.val);
        }
    }
}
