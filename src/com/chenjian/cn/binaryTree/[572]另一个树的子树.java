package com.chenjian.cn.binaryTree;//给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看
//做它自身的一棵子树。 
//
// 示例 1: 
//给定的树 s: 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
// 
//
// 给定的树 t： 
//
// 
//   4 
//  / \
// 1   2
// 
//
// 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。 
//
// 示例 2: 
//给定的树 s： 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
//    /
//   0
// 
//
// 给定的树 t： 
//
// 
//   4
//  / \
// 1   2
// 
//
// 返回 false。 
// Related Topics 树 
// 👍 491 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


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
class Solution572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        return DFS(root, subRoot);
    }

    public boolean DFS(TreeNode root, TreeNode subRoot){
        if (root == null)
            return false;

        return compare(root,subRoot) || DFS(root.left, subRoot) || DFS(root.right, subRoot);
    }

    public boolean compare(TreeNode left, TreeNode right){
        if (left == null && right == null)
            return true;
        else if (left != null && right == null)
            return false;
        else if (left == null && right != null)
            return false;
        else if (left.val != right.val)
            return false;

        boolean isLeft = compare(left.left, right.left);
        boolean isRight = compare(left.right, right.right);
        return isLeft && isRight;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
