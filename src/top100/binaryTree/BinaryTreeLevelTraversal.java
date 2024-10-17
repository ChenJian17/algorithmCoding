package top100.binaryTree;

import com.chenjian.cn.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/10/16 23:29
 */
public class BinaryTreeLevelTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {


        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i<size; i++){
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                tmp.add(node.val);
            }
            res.add(tmp);
        }
        return res;

    }
}
