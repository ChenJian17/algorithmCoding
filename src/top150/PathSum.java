package top150;

import com.chenjian.cn.util.TreeNode;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/7/24 19:45
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root == null){
            return false;
        }
        return dfs(root,targetSum);

    }

    public boolean dfs(TreeNode root, int targetSum){
        targetSum -= root.val;
        if(root.left == null && root.right == null){
            return targetSum == 0;
        }
        if(root.left != null && root.right != null){
            return dfs(root.left,targetSum)
                    || dfs(root.right,targetSum);
        }

        if (root.left == null){
            return dfs(root.right,targetSum);
        }
        return dfs(root.left,targetSum);


    }

    public static void main(String[] args) {

    }
}
