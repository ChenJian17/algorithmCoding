package top100.binaryTree;

import com.chenjian.cn.util.TreeNode;

import java.util.Date;
import java.util.Map;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/3/1 21:39
 */
public class MaxPathSum {
    Integer sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        DFS(root);
        return sum;
    }

    public int DFS(TreeNode root){
        if (root == null)
            return 0;

        int left = DFS(root.left);
        int right = DFS(root.right);
        int cur = root.val+ Math.max(left,right);

        sum = Math.max(sum,root.val+left+right);

        return Math.max(cur, 0);
    }


//    public int[] transformArray(int[] nums) {
//        int count = 0;
//        for (int num: nums){
//            if (num %2 == 0)
//                count++;
//        }
//
//        for (int i = 0; i<nums.length; i++){
//            if (i < count)
//                nums[i] = 0;
//            else
//                nums[i] = 1;
//        }
//        return nums;
//
//    }
}
