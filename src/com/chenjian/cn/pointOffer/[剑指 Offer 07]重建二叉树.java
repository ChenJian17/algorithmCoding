package com.chenjian.cn.pointOffer;//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//
// 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归 
// 👍 483 👎 0


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
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution07 {
    Map<Integer, Integer> map = new HashMap<>();
    int[] pre;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i=0;i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        pre = preorder;
        return rebuild(0,preorder.length-1,0,inorder.length-1);

    }

    public TreeNode rebuild(int start1, int end1, int start2, int end2){
        if (start1>end1 || start2>end2)
            return null;
        int value = pre[start1];
        int key = map.get(value);
        TreeNode root = new TreeNode(value);
        root.left = rebuild(start1+1,start1+key-start2,start2,key-1);
        root.right = rebuild(start1+key-start2+1,end1,key+1,end2);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
