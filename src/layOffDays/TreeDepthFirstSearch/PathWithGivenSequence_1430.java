package layOffDays.TreeDepthFirstSearch;

import com.chenjian.cn.util.TreeNode;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/4/3 12:08
 */
public class PathWithGivenSequence_1430 {

    public boolean isValidSequence(TreeNode root, int[] arr) {
        return dfs(root, arr, 0);
    }

    public boolean dfs(TreeNode root, int[] arr, int i) {
        if (root == null || i >= arr.length || arr[i] != root.val )
            return false;
        if (root.left == null && root.right == null) {
            return i == arr.length-1;
        }
        return dfs(root.left, arr, i+1)
                || dfs(root.right, arr, i+1);
    }
}
