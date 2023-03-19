package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 树 广度优先搜索 二叉树 
// 👍 264 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.chenjian.cn.util.TreeNode;

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
class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[]{};

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            list.add(tmp.val);
            if (tmp.left != null){
                queue.offer(tmp.left);
            }
            if (tmp.right != null) {
                queue.offer(tmp.right);
            }
        }
        int[] res = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
