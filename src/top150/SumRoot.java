package top150;

import com.chenjian.cn.util.TreeNode;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/7/30 14:23
 */
public class SumRoot {

    int res = 0;
    public int sumNumbers(TreeNode root) {

        DFS(root, "");
        return res;

    }

    public void DFS(TreeNode root, String sum){
        if(root == null){
            int tmp = Integer.parseInt(sum);
            res += tmp;
            return;
        }

        sum += root.val;
        DFS(root.left,sum);
        DFS(root.right,sum);
    }

}
