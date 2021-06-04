package com.chenjian.cn.binaryTree;//计算给定二叉树的所有左叶子之和。
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 
// 👍 312 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import com.chenjian.cn.util.TreeNodeUtil;
import com.chenjian.cn.util.TreeNode;
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
class Solution404 {

    int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
         dfs(root, 0);
         return res;

    }
    public void dfs(TreeNode root, int res){
        if (root == null)
            return;

        if (root.left != null && root.left.left == null && root.right.right == null)
            res += root.left.val;


        dfs(root.left, res);
        dfs(root.right, res);
    }

    public int sumOfLeftLeaves2(TreeNode root){
        if (root == null)
            return 0;
        int leftValue = sumOfLeftLeaves(root.left);
        int righValue = sumOfLeftLeaves(root.right);
        int value = 0;
        if (root.left != null && root.left.left == null && root.right.right == null)
            value = root.left.val;
        int sum = value + leftValue +righValue;
        return sum;
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{3,9,20,null,null,15,7};
        TreeNode treeNode = TreeNodeUtil.arrayToTreeNode(array);
        Solution404 s = new Solution404();
        s.sumOfLeftLeaves(treeNode);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
