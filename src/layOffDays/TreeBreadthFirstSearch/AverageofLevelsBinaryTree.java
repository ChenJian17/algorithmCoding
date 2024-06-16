package layOffDays.TreeBreadthFirstSearch;

import com.chenjian.cn.util.TreeNode;

import java.util.*;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/1/12 22:31
 */
public class AverageofLevelsBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);
        List<Double> res = new ArrayList<>();
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

            res.add(getAverage(tmp));
        }
        return res;

    }

    public Double getAverage(List<Integer> list) {
        Double sum = (double) 0;
        for (int i = 0; i<list.size(); i++) {
            sum += list.get(i);
        }
        return sum/list.size();

    }
}
