package com.chenjian.cn.binaryTree;//给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
//
// 两棵树重复是指它们具有相同的结构以及相同的结点值。 
//
// 示例 1： 
//
//         1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
// 
//
// 下面是两个重复的子树： 
//
//       2
//     /
//    4
// 
//
// 和 
//
//     4
// 
//
// 因此，你需要以列表的形式返回上述重复子树的根结点。 
// Related Topics 树 
// 👍 278 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.chenjian.cn.util.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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
class Solution652 {
    //记录所有子树以及出现的次数
    Map<String, Integer> map = new HashMap<>();
    //存放重复子树的根节点
    List<TreeNode> res = new LinkedList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    public String traverse(TreeNode root){
        if (root == null)
            return "#";

        String left = traverse(root.left);
        String right = traverse(root.right);
        String sub = left +","+right+","+root.val;

        //获取这个字符串在map中的出现次数
        int count = map.getOrDefault(sub, 0);

        //如果为1，说明之前出现过一次，是重复子树
        if (count == 1){
            res.add(root);
        }
        map.put(sub, count+1);

        return sub;



    }
}
//leetcode submit region end(Prohibit modification and deletion)
