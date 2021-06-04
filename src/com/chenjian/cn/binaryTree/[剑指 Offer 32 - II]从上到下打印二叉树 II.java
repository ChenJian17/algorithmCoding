package com.chenjian.cn.binaryTree;//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
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
//  [9,20],
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
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-tra
//versal/ 
// Related Topics 树 广度优先搜索 
// 👍 83 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import com.chenjian.cn.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}

class Solution32 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        while(!queue.isEmpty() || !queue1.isEmpty()){
            List<Integer> list = new ArrayList<>();
            while(!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if(temp.left != null) queue1.offer(temp.left);
                if(temp.right != null) queue1.offer(temp.right);
            }
            if(!list.isEmpty()) result.add(list);

            List<Integer> list1 = new ArrayList<>();
            while(!queue1.isEmpty()) {

                TreeNode temp1 = queue1.poll();
                list1.add(temp1.val);
                if(temp1.left != null) queue.offer(temp1.left);
                if(temp1.right != null) queue.offer(temp1.right);
            }
            if(!list1.isEmpty()) result.add(list1);


        }
        return result;

    }

    public static void main(String[] args){
        TreeNode c = new TreeNode(15);
        c.left = null;
        c.right = null;
        TreeNode d = new TreeNode(7);
        d.left = null;
        d.right = null;
        TreeNode a = new TreeNode(9);
        a.left = null;
        a.right = null;

        TreeNode b = new TreeNode(20);
        b.left = c;
        b.right = d;

        TreeNode root = new TreeNode(3);
        root.left = a;
        root.right = b;

        levelOrder(root);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
