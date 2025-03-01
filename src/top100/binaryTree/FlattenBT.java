package top100.binaryTree;

import com.chenjian.cn.util.TreeNode;
import com.chenjian.cn.util.TreeNodeUtil;

import java.util.*;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/2/22 22:08
 */
public class FlattenBT {

//    List<TreeNode> treeNodes = new ArrayList<>();
//    public void flatten(TreeNode root) {
//        DFS(root);
//        for (int i = 0; i < treeNodes.size(); i++){
//            TreeNode node = treeNodes.get(i);
//            node.left = null;
//            if (i != treeNodes.size()-1){
//                node.right = treeNodes.get(i+1);
//            }
//
//        }
//    }
//    public void DFS(TreeNode cur){
//        if (cur == null)
//            return;
//
//        treeNodes.add(cur);
//        DFS(cur.left);
//        DFS(cur.right);
//
//    }

    public void flatten(TreeNode root){
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if (pre != null){
                pre.left = null;
                pre.right = cur;
            }
            TreeNode left = cur.left, right = cur.right;
            // 使用栈保存右节点
            if (right != null)
                stack.push(right);
            if (left != null)
                stack.push(left);
            pre = cur;
        }

    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,5,3,4,null,6};
        TreeNode node = TreeNodeUtil.arrayToTreeNode(arr);

        FlattenBT flattenBT = new FlattenBT();
        flattenBT.flatten(node);
    }
}
