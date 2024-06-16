package layOffDays.TreeBreadthFirstSearch;

import com.chenjian.cn.util.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/2/28 15:43
 */
public class ProblemChallenge1 {

    public static void populate_sibling_pointers(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
            node.next = queue.peek();
        }
        return;
    }
}
