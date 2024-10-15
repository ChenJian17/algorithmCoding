package top100.binaryTree;

import com.chenjian.cn.util.TreeNode;

import java.util.*;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/10/11 16:36
 */
public class BinaryTreeInorderTraversal {

//    List<Integer> res = new ArrayList<>();
//    public List<Integer> inorderTraversal(TreeNode root) {
//        traverse(root);
//        return res;
//    }
//
//    public void traverse(TreeNode root){
//        if (root == null)
//            return;
//        traverse(root.left);
//        res.add(root.val);
//        traverse(root.right);
//    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (stack.size() > 0 || root != null){
            if (root != null){
                stack.push(root);
                root = root.left;
            }else {
                TreeNode tmp = stack.pop();
                res.add(tmp.val);
                root = tmp.right;
            }
        }
        return res;
    }
}
