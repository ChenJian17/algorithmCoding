package layOffDays.TreeDepthFirstSearch;

import com.chenjian.cn.util.TreeNode;
import com.chenjian.cn.util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: sherlockchen
 * @date: 2024/3/22 00:04
 */
public class PathSum2 {

//    List<List<Integer>> res = new ArrayList<>();
//    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//        if (root == null)
//            return res;
//        List<Integer> path = new ArrayList<>();
//        path.add(root.val);
//        if (root.left == null && root.right == null)
//            res.add(path);
//        pathSum(root.left, targetSum-root.val, new ArrayList<>(path));
//        pathSum(root.right, targetSum-root.val, new ArrayList<>(path));
//        List<List<Integer>> myList = res.stream().distinct().toList();
//
//        return res;
//    }

//    public void pathSum(TreeNode root, int targetSum, List<Integer> path){
//        if (root == null) {
//            if (targetSum == 0)
//                res.add(path);
//            return;
//        }
//        path.add(root.val);
//        pathSum(root.left, targetSum-root.val, new ArrayList<>(path));
//        pathSum(root.right, targetSum-root.val, new ArrayList<>(path));
//
//    }

    // 使用回溯避免添加重复值
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        pathSum2(root, targetSum);
        return res;
    }

    public void pathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null && targetSum-root.val == 0) {
            res.add(new ArrayList<>(path));
        }
        pathSum2(root.left, targetSum-root.val);
        pathSum2(root.right, targetSum-root.val);
        path.remove(path.size()-1);

    }



    public static void main(String[] args) {
        Integer[] array = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        TreeNode root = TreeNodeUtil.arrayToTreeNode(array);
        PathSum2 sum2 = new PathSum2();
//        sum2.pathSum(root, 22);
    }

}
