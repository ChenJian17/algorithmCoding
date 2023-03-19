package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 430 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.chenjian.cn.util.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return helper(root.left,root.right);
    }
    public boolean helper(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null){
            return true;
        }
        if (root1 == null || root2 == null){
            return false;
        }
        if (root1.val == root2.val){
            return helper(root1.right, root2.left)
                    && helper(root1.left,root2.right);

        }else {
            return false;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
