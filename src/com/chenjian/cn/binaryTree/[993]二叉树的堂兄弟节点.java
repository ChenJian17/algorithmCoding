package com.chenjian.cn.binaryTree;//在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
//
// 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。 
//
// 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。 
//
// 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。 
//
// 
//
// 示例 1： 
// 
//
// 
//输入：root = [1,2,3,4], x = 4, y = 3
//输出：false
// 
//
// 示例 2： 
// 
//
// 
//输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
//输出：true
// 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [1,2,3,null,4], x = 2, y = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点数介于 2 到 100 之间。 
// 每个节点的值都是唯一的、范围为 1 到 100 的整数。 
// 
//
// 
// Related Topics 树 广度优先搜索 
// 👍 200 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.chenjian.cn.util.TreeNode;
import com.chenjian.cn.util.TreeNodeUtil;

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
class Solution993 {
//    public boolean isCousins(TreeNode root, int x, int y) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        int flag = 0;
//        while (!queue.isEmpty()){
//            int size = queue.size();
//            TreeNode one = null, two = null;
//
//            for (int i=0; i<size; i++){
//                TreeNode tmp = queue.poll();
//                if (tmp.left != null) {
//                    queue.offer(tmp.left);
//                    if (tmp.left.val == x ||tmp.left.val == y){
//                        flag++;
//                        if (one == null)
//                            one = tmp;
//                        else
//                            two = tmp;
//                    }
//
//                }
//                if (tmp.right != null) {
//                    queue.offer(tmp.right);
//                    if (tmp.right.val == y||tmp.right.val == x){
//                        flag++;
//                        if (one == null)
//                            one = tmp;
//                        else
//                            two = tmp;
//                    }
//
//                }
//            }
//            if (flag == 2 && one!= null && two!=null && one.val != two.val)
//                break;
//            else
//                flag = 0;
//
//        }
//        if (flag == 2)
//            return true;
//        else
//            return false;
//
//    }



    //x的信息
    int x;
    TreeNode xParent;
    int xDepth;
    boolean xFound = false;
    // y 的信息
    int y;
    TreeNode yParent;
    int yDepth;
    boolean yFound = false;

    public boolean isCousins(TreeNode root, int x, int y){
        this.x = x;
        this.y = y;
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> depthQueue = new LinkedList<Integer>();
        nodeQueue.offer(root);
        depthQueue.offer(0);
        update(root, null, 0);
        while (!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.poll();
            int depth = depthQueue.poll();
            if (node.left != null) {
                nodeQueue.offer(node.left);
                depthQueue.offer(depth + 1);
                update(node.left, node, depth + 1);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                depthQueue.offer(depth + 1);
                update(node.right, node, depth + 1);
            }
            if (xFound && yFound) {
                break;
            }

        }
        return xDepth == yDepth && xParent != yParent;
    }

    public void update(TreeNode node, TreeNode parent, int depth){
        if (node.val == x) {
            xParent = parent;
            xDepth = depth;
            xFound = true;
        } else if (node.val == y) {
            yParent = parent;
            yDepth = depth;
            yFound = true;
        }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,2,3,null,4,null,5};
        TreeNode root = TreeNodeUtil.arrayToTreeNode(array);
//        new Solution993().isCousins(root,5,4);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
