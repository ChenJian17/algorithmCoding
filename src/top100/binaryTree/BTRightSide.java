package top100.binaryTree;

import com.chenjian.cn.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/2/21 22:14
 */
public class BTRightSide {

    public List<Integer> rightSideView(TreeNode root){

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i<len; i++){
                TreeNode node = queue.poll();
                if (i == (len-1)){
                    res.add(node.val);
                }
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);

            }
        }
        return res;

    }
}
