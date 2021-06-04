package com.chenjian.cn.binaryTree;//给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
//
// 
//
// 示例 1： 
//
// 
//输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
//输出：32
// 
//
// 示例 2： 
//
// 
//输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 2 * 104] 内 
// 1 <= Node.val <= 105 
// 1 <= low <= high <= 105 
// 所有 Node.val 互不相同 
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 217 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import com.chenjian.cn.util.TreeNode;

import java.util.ArrayList;
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
class Solution938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        List<Integer> list = new ArrayList<>();
        DFS(root, list, low, high);
        int sum = 0;
        for (int num: list){
            sum += num;
        }
        return sum;



    }

    public static void DFS(TreeNode root, List<Integer> list, int low, int high){
        if (root == null)
            return;
        DFS(root.left, list, low, high);
        if (root.val >= low && root.val <= high)
            list.add(root.val);
        DFS(root.right, list, low, high);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
