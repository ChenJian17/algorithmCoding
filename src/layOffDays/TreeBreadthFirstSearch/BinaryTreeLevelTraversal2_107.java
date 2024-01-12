package layOffDays.TreeBreadthFirstSearch;

import com.chenjian.cn.util.TreeNode;

import java.util.*;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/1/11 22:57
 */
public class BinaryTreeLevelTraversal2_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int length = queue.size();
            for (int i = 0; i< length; i++) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            res.add(tmp);
        }
        Collections.reverse(res);
        return res;


    }
}
