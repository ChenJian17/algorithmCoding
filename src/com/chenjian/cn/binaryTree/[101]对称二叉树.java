package com.chenjian.cn.binaryTree;//给定一个二叉树，检查它是否是镜像对称的。
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1367 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import com.chenjian.cn.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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
class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return compare(root.left, root.right);

    }
    public boolean compare(TreeNode left, TreeNode right){
        if (left == null && right != null)
            return false;
        else if(left != null && right == null)
            return false;
        else if (left == null && right == null)
            return true;
        else if (left.val != right.val)
            return false;

        boolean isLeft = compare(left.left, right.right);
        boolean isRight = compare(left.right, right.left);

        return isLeft && isRight;

    }


    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null)
                continue;
            if ((left == null || right == null || (left.val != right.val)))
                return false;

            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
