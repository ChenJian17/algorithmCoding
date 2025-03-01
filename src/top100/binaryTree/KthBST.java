package top100.binaryTree;

import com.chenjian.cn.util.TreeNode;
import com.chenjian.cn.util.TreeNodeUtil;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/2/20 20:34
 */
public class KthBST {


    private int k;
    public int kthSmallest(TreeNode root, int k){
        this.k = k;
        return find(root);
    }

    public int find(TreeNode root){
       if (root == null)
           return -1;
       int res = find(root.left);
       if (res == -1){
           k = k-1;
           if (k == 0)
               return root.val;
           return find(root.right);
       }else {
           return res;
       }

    }


    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,1,4,null,2};
        TreeNode node = TreeNodeUtil.arrayToTreeNode(arr);
        KthBST kthBST = new KthBST();

    }
}
