package com.chenjian.cn.binaryTree;//根据一棵树的中序遍历与后序遍历构造二叉树。
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 496 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.chenjian.cn.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

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
class Solution106 {
    Map<Integer, Integer> map = new HashMap<>();
    int[] post;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i =0; i<inorder.length; i++)
            map.put(inorder[i], i);
        post = postorder;
        TreeNode root = buildTree(0, inorder.length-1, 0, postorder.length-1);
        return root;

    }

    public TreeNode buildTree(int start1, int end1, int start2, int end2){
        if (start1 > end1 || start2 > end2)
            return null;
        int value = post[end2];
        int key = map.get(value);

        TreeNode root = new TreeNode(value);
        root.left = buildTree(start1,key-1, start2, start2+key-start1-1);
        root.right = buildTree(key+1, end1,start2+key-start1, end2-1);
        return root;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
