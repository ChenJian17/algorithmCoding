package layOffDays.TreeBreadthFirstSearch;

import com.chenjian.cn.util.TreeNode;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/1/12 22:55
 */
public class MinimumDepthOfBinaryTree {



    public int depth(TreeNode root, int height) {
        if (root == null)
            return height;
        if (root.left != null)
            return depth(root.left, height+1);
        if (root.right != null)
            return depth(root.right, height+1);
       return height;
    }



}
