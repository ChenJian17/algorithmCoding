package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 树 深度优先搜索 二叉树 
// 👍 717 👎 0


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
class Solution26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null){
            return false;
        }
        if ((A.val == B.val) && helper(A.left,B.left) && helper(A.right,B.right)){
            return true;
        }
        return isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    private boolean helper(TreeNode root1, TreeNode root2){
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root1.val == root2.val){
            return helper(root1.left,root2.left) && helper(root1.right, root2.right);
        }else {
            return false;
        }

    }


}
//leetcode submit region end(Prohibit modification and deletion)
