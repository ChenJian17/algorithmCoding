package com.chenjian.cn.binaryTree;//给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
//
// 
//
// 示例： 
//
// 输入：
//
//   1
//    \
//     3
//    /
//   2
//
//输出：
//1
//
//解释：
//最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
// 
//
// 
//
// 提示： 
//
// 
// 树中至少有 2 个节点。 
// 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 
//相同 
// 
// Related Topics 树 
// 👍 251 👎 0


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
class Solution530 {
    List<Integer> list = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        DFS(root);
        if (list.size()<2) return 0;
        int res = Integer.MAX_VALUE;
        for (int i =1; i<list.size(); i++){
            res = Math.min(res, list.get(i)-list.get(i-1));
        }
        return res;

    }

    public void DFS(TreeNode root){
        if (root== null) return;
        DFS(root.left);
        list.add(root.val);
        DFS(root.right);

    }

    int res = Integer.MAX_VALUE;
    TreeNode pre;
    public int getMinimumDifference2(TreeNode root){
        traversal(root);
        return res;

    }

    public void traversal(TreeNode cur){
        if (cur == null) return;
        traversal(cur.left);
        if (pre != null){
            res = Math.min(res, cur.val-pre.val);
        }
        pre = cur;
        traversal(cur.right);

    }

}
//leetcode submit region end(Prohibit modification and deletion)
