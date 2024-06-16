package layOffDays.TreeBreadthFirstSearch;

import com.chenjian.cn.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/2/28 14:02
 */
public class LevelOrderSuccessor {

    public TreeNode levelOrderSuccessor(TreeNode root, int key){
        if (root == null)
            return null;
        if (root.val == key) {
            return root.left != null ? root.left : root.right;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            if (node.val == key)
                break;
        }
        return queue.peek();

    }
}
