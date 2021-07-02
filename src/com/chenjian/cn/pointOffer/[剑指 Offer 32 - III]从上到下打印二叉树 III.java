package com.chenjian.cn.pointOffer;//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 108 👎 0


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
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution32_Offer {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //用于控制是否反转
        int flag = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i=0; i<size; i++){
                TreeNode tmp = queue.poll();
                list.add(tmp.val);
                if (tmp.left != null) queue.offer(tmp.left);
                if (tmp.right != null) queue.offer(tmp.right);

            }
            if (flag < 0)
                Collections.reverse(list);

            flag = -flag;
            res.add(list);
        }
        return res;

    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4,null,null,5};
        TreeNode treeNode = TreeNodeUtil.arrayToTreeNode(arr);
        new Solution32_Offer().levelOrder(treeNode);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
