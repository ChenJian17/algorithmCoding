package layOffDays.TreeBreadthFirstSearch;

import com.chenjian.cn.util.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/2/27 23:37
 */
public class ConnectLevelOrderSiblings {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null)
            return null;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i<size; i++) {
                Node node = queue.poll();
                if (i == (size-1)) {
                    node.next = null;
                }else {
                    node.next = queue.peek();
                }
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }

        return root;
    }
}
