package layOffDays.TreeBreadthFirstSearch;

import com.chenjian.cn.util.TreeNode;
import com.chenjian.cn.util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/2/28 15:59
 */
public class ProblemChallenge2 {

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i<size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                if (i == (size-1)) {
                    res.add(node.val);
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,null,3};
        TreeNode treeNode = TreeNodeUtil.arrayToTreeNode(array);
        rightSideView(treeNode);
    }
}
