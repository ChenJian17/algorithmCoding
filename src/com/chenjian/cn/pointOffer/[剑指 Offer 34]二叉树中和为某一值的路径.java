package com.chenjian.cn.pointOffer;//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
//
// 
//
// 示例: 
//给定如下二叉树，以及目标和 target = 22， 
//
// 
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// 
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 回溯 二叉树 
// 👍 199 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.chenjian.cn.util.TreeNode;
import com.chenjian.cn.util.TreeNodeUtil;

import java.util.*;

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
//    List<List<Integer>> res = new ArrayList<>();
//
//    public List<List<Integer>> pathSum(TreeNode root, int target) {
//        if (root == null)
//            return res;
//
//        DFS(root,target,0,new ArrayList<>());
//        return res;
//    }
//
//    public void DFS(TreeNode root, int target, int sum, List<Integer> path){
//        if (sum+root.val == target && root.left == null && root.right == null){
//            path.add(root.val);
//            res.add(path);
//            return;
//        }
//        path.add(root.val);
//        if (root.left != null)
//            DFS(root.left,target,sum+root.val,new ArrayList<>(path));
//
//        if (root.right != null)
//            DFS(root.right, target, sum+root.val, new ArrayList<>(path));
//
//    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null)
            return res;

        DFS(root,target);
        return res;
    }

    public void DFS(TreeNode root, int target){
        if (root == null)
            return;
        path.add(root.val);
        target -= root.val;

        if (root.val == 0 && root.left == null && root.right == null){
            res.add(new ArrayList<>(path));
            return;
        }

        DFS(root.left, target);
        DFS(root.right, target);

        //回溯
        path.remove(path.size()-1);

    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1};
        TreeNode root = TreeNodeUtil.arrayToTreeNode(arr);
        new Solution34().pathSum(root,-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
