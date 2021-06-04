package com.chenjian.cn.binaryTree;//给定一个二叉树，在树的最后一行找到最左边的值。
//
// 示例 1: 
//
// 
//输入:
//
//    2
//   / \
//  1   3
//
//输出:
//1
// 
//
// 
//
// 示例 2: 
//
// 
//输入:
//
//        1
//       / \
//      2   3
//     /   / \
//    4   5   6
//       /
//      7
//
//输出:
//7
// 
//
// 
//
// 注意: 您可以假设树（即给定的根节点）不为 NULL。 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 169 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.chenjian.cn.util.TreeNode;

import java.security.spec.DSAGenParameterSpec;
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
class Solution {
    int maxLen = Integer.MIN_VALUE;
    int maxleftValue;
    void DFS(TreeNode root, int leftLen){
        if (root.left == null && root.right == null){
            if (leftLen > maxLen){
                maxLen = leftLen;
                maxleftValue = root.val;
            }
            return;
        }

        if (root.left != null){
            leftLen ++;
            DFS(root, leftLen);
            leftLen --;
        }
        if (root.right != null){
            leftLen ++;
            DFS(root, leftLen);
            leftLen --;
        }
        return;
    }
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i<size; i++){
                TreeNode temp = queue.poll();
                if (i == 0)  res = temp.val;
                if (temp.left != null) {
                    queue.offer(temp.left);

                }
                if (temp.right != null) {
                    queue.offer(temp.right);

                }
            }

        }
        return res;

    }

    public int findBottomLeftValue2(TreeNode root){
        DFS(root, 0);
        return maxleftValue;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
