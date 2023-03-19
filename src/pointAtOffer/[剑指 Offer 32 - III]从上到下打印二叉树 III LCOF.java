package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 树 广度优先搜索 二叉树 
// 👍 283 👎 0


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
class Solution32III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Boolean flag = false;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();

            for (int i = 0; i<size; i++) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            if (flag) {
                Collections.reverse(tmp);
                flag = false;
            }else {
                flag = true;
            }
            list.add(tmp);
        }
        return list;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
