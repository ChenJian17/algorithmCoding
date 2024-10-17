package top100.binaryTree;

import com.chenjian.cn.util.TreeNode;
import com.chenjian.cn.util.TreeNodeUtil;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/10/16 21:25
 */
public class DiameterBinaryTree {

    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return res;
    }

    public int diameter(TreeNode root) {
        if (root == null)
            return 0;

        int left = diameter(root.left);
        int right = diameter(root.right);
        res = Math.max(res, left+right);

        return Math.max(left,right)+1;

    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4,5};

        TreeNode root = TreeNodeUtil.arrayToTreeNode(arr);
        DiameterBinaryTree tree = new DiameterBinaryTree();
        tree.diameterOfBinaryTree(root);

    }

}
