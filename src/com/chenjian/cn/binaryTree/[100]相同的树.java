package com.chenjian.cn.binaryTree;//给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 
//
// 示例 1： 
//
// 
//输入：p = [1,2,3], q = [1,2,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：p = [1,2], q = [1,null,2]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：p = [1,2,1], q = [1,1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 两棵树上的节点数目都在范围 [0, 100] 内 
// -104 <= Node.val <= 104 
// 
// Related Topics 树 深度优先搜索 
// 👍 614 👎 0


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
class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p != null && q == null)
            return false;
        else if (p == null && q != null)
            return false;
        else if (p.val != q.val)
            return false;

        boolean isLeft = isSameTree(p.left, q.left);
        boolean isRight = isSameTree(p.right, q.right);
        return isLeft && isRight;

    }
//    public boolean compare(TreeNode left, TreeNode right){
//        if (left == null && right == null)
//            return true;
//        else if (left != null && right == null)
//            return false;
//        else if (left == null && right != null)
//            return false;
//        else if (left.val != right.val)
//            return false;
//
//        boolean isLeft = compare(left.left, right.left);
//        boolean isRight = compare(left.right, right.right);
//        return isLeft && isRight;
//    }

    public boolean isSameTree2(TreeNode p, TreeNode q){

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null)
                continue;
            if ((left == null || right == null || (left.val != right.val)))
                return false;
            queue.offer(left.left);
            queue.offer(right.left);
            queue.offer(left.right);
            queue.offer(right.right);
        }
        return true;

    }

}
//leetcode submit region end(Prohibit modification and deletion)
