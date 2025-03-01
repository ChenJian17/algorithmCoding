package top100.binaryTree;

import com.chenjian.cn.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/2/24 23:50
 */
public class ConstructBT {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return DFS(preorder,0,preorder.length,inorder,0,inorder.length,map);

    }

    public TreeNode DFS(int[] preorder, int pre_s, int pre_e,
                        int[] inorder, int in_s, int in_e, Map<Integer,Integer> map){
        if (pre_s == pre_e){
            return null;
        }

        int val = preorder[pre_s];
        TreeNode root = new TreeNode(val);
        int mid = map.get(val);
        int gap = mid-in_s;
        root.left = DFS(preorder,pre_s+1,pre_s+gap+1,inorder,in_s,mid,map);
        root.right = DFS(preorder,pre_s+gap+1,pre_e,inorder,mid+1,in_e,map);
        return root;

    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};

        ConstructBT bt = new ConstructBT();
        bt.buildTree(preorder,inorder);
    }
}
