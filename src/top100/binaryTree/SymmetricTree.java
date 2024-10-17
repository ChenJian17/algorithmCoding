package top100.binaryTree;
import com.chenjian.cn.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/10/15 22:34
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if(root==null) {
            return true;
        }
        return isSym(root.left, root.right);
    }

    public boolean isSym(TreeNode left, TreeNode right){
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;

        if (left.val != right.val)
            return false;
        else
            return isSym(left.right, right.left) && isSym(left.left, right.right);

    }


    public boolean isSymmetric1(TreeNode root){
        if (root == null && (root.left == null && root.right == null))
            return true;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (queue.size() > 0){
            TreeNode left = queue.removeFirst();
            TreeNode right = queue.removeFirst();
            if (left == null && right == null)
                continue;
            if (left == null || right == null)
                return false;
            if (left.val != right.val)
                return false;
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;

    }
}
