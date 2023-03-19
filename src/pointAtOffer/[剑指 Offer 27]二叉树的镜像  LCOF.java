package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 341 👎 0


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
class Solution27 {
    public TreeNode mirrorTree(TreeNode root) {
        reverse(root);
        return root;
    }

    public void reverse(TreeNode root) {
        if (root != null){
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = right;
            root.right = left;
            reverse(root.left);
            reverse(root.right);
        }

    }


}
//leetcode submit region end(Prohibit modification and deletion)
