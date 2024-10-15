package top100.binaryTree;

import com.chenjian.cn.util.TreeNode;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/10/14 23:14
 */
public class MaxDepthBinaryTree {
    public int maxDepth(TreeNode root) {

        if (root == null){
            return 0;
        }

        return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);

    }
}
