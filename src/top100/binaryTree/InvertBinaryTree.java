package top100.binaryTree;

import com.chenjian.cn.util.TreeNode;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/10/14 23:42
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        root.left = invertTree(root.left);
        root.right = invertTree(root.right);

        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        return root;

    }

}
