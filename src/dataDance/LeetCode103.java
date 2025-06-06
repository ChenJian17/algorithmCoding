package dataDance;

import com.chenjian.cn.util.TreeNode;

import java.util.*;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/5/12 22:06
 */
public class LeetCode103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        while (!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i<size; i++){
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right!= null)
                    queue.offer(node.right);
                tmp.add(node.val);
            }
            if (flag){
                Collections.reverse(tmp);
            }
            res.add(tmp);
            flag = !flag;
        }

        return res;
    }
}
