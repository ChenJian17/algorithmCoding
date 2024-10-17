package top100.binaryTree;

import com.chenjian.cn.util.TreeNode;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/10/17 15:28
 */
public class ConvertSortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return DFS(nums, 0, nums.length-1);
    }

    public TreeNode DFS(int[] nums, int left, int right){
        if (left > right)
            return null;
        int mid = left+(right-left)/2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = DFS(nums, left, mid-1);
        root.right = DFS(nums, mid+1, right);
        return root;
    }
}
