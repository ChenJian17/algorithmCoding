package top100.binaryTree;

import com.chenjian.cn.util.TreeNode;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/10/17 16:14
 */
public class ValidateBST {
    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root){
        if (root == null)
            return true;
        if (!isValidBST(root.left) || pre >= root.val){
            return false;
        }

        pre = root.val;

        return isValidBST(root.right);
    }

}
