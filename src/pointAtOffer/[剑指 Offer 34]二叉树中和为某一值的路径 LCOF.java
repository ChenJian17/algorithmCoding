package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 树 深度优先搜索 回溯 二叉树 
// 👍 414 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.chenjian.cn.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution34 {
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        helper(root,target);
        return res;

    }
    public void helper(TreeNode root, int target){
        if (root == null){
            return;
        }
        path.add(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0){
            res.add(new LinkedList<>(path));
        }
        helper(root.left,target);
        helper(root.right,target);
        path.removeLast();

    }
}
//leetcode submit region end(Prohibit modification and deletion)
