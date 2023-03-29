package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 374 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.chenjian.cn.util.TreeNode;
import com.chenjian.cn.util.TreeNodeUtil;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution54 {
    int target = 0;
    int count = 0;
    public int kthLargest(TreeNode root, int k) {
        count = k;
        helper(root);

        return target;
    }
    public void helper(TreeNode root){
        if (root == null)
            return;
        helper(root.right);
//        if (count == 1){
//            target = root.val;
//            count = Integer.MAX_VALUE;
//        }else {
//            count --;
//        }
        if (--count == 1){
            target = root.val;
        }
        if (count == 1) return;
        helper(root.left);

    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{3,1,4,null,2};
        TreeNode root = TreeNodeUtil.arrayToTreeNode(array);
        new Solution54().kthLargest(root,1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
