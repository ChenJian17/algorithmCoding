package com.chenjian.cn.binaryTree;//翻转一棵二叉树。
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树 
// 👍 840 👎 0


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
class Solution226 {
    public TreeNode invertTree(TreeNode root) {
//        if (root == null)
//            return root;
//        swap(root);
//        invertTree(root.left);
//        invertTree(root.right);
//        reverse(root);
        return reverse(root);

    }

    //没有过
//    void reverse(TreeNode root){
//        if (root == null)
//            return;
//        TreeNode temp = root.right;
//        root.right = root.left;
//        root.left = temp;
//        reverse(root.left);
//        reverse(root.right);
//    }
    void  swap(TreeNode root){
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
    }

    TreeNode reverse(TreeNode root){
        if (root == null)
            return root;
        TreeNode left = reverse(root.left);
        TreeNode right = reverse(root.right);
        root.left = right;
        root.right = left;
        return root;

    }

}
//leetcode submit region end(Prohibit modification and deletion)
