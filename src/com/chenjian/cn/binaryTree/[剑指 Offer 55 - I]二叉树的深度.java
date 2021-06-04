package com.chenjian.cn.binaryTree;//输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
//
// 例如： 
//
// 给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tre
//e/ 
// Related Topics 树 深度优先搜索 
// 👍 90 👎 0


//leetcode submit region begin(Prohibit modification and deletion)



import com.chenjian.cn.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}

class Solution55 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while(!queue.isEmpty()){
            res++;
            int n = queue.size();
            for(int i =0; i< n; i++){
                TreeNode t = queue.poll();
                if(t.left != null)
                    queue.add(t.left);
                if(t.right != null)
                    queue.add(t.right);
            }

        }
        return res;

    }


}
//leetcode submit region end(Prohibit modification and deletion)
