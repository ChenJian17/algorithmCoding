package top100.binaryTree;

import com.chenjian.cn.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/2/26 22:24
 */
public class PathSumIII {

    Map<Long, Integer> map = new HashMap<>();
    int target;
    public int pathSum(TreeNode root, int targetSum){
        map.put(0L,1);
        target = targetSum;
        return DFS(root,0);
    }

    public int DFS(TreeNode root, long curSum){
        if (root == null)
            return 0;
        curSum += root.val;

        int res = 0;
        res += map.getOrDefault(curSum-target,0);

        map.put(curSum,map.getOrDefault(curSum,0)+1);

        int left = DFS(root.left, curSum);
        int right = DFS(root.right, curSum);

        map.put(curSum,map.get(curSum)-1);

        return res+left+right;

    }
}
