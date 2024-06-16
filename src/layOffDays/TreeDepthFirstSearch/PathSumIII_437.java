package layOffDays.TreeDepthFirstSearch;

import com.chenjian.cn.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/4/5 17:45
 */
public class PathSumIII_437 {

    //核心思想：两节点间的路径和 = 两节点的前缀和之差
    //限制：路径方向必须是向下的（只能从父节点到子节点）

    Map<Long, Integer> prefixMap = new HashMap<>();
    Integer target;
    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        prefixMap.put(0L,1);
        return dfs(root, 0L);
    }

    public int dfs(TreeNode root, Long curSum) {
        if (root == null)
            return 0;
        curSum += root.val;
        // 有多少个这样的节点
        int res = prefixMap.getOrDefault(curSum-target, 0);
        // 记录每个前缀和
        prefixMap.put(curSum, prefixMap.getOrDefault(curSum,0)+1);

        int left = dfs(root.left, curSum);
        int right = dfs(root.right, curSum);

        prefixMap.put(curSum, prefixMap.get(curSum)-1);
        return res+left+right;
    }
}
