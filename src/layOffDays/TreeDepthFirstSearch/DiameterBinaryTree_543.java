package layOffDays.TreeDepthFirstSearch;

import com.chenjian.cn.util.TreeNode;
import com.chenjian.cn.util.TreeNodeUtil;

import java.text.MessageFormat;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/4/5 20:25
 */
public class DiameterBinaryTree_543 {
    int res = -1;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res-1;
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(res, left+right+1);
        return 1+Math.max(left,right);
    }

//    Integer max = -1;
//    public  int diameterOfBinaryTree(TreeNode root) {
//        if (root == null) return 0;
//        dfs(root);
//        return max;
//    }
//
//    public void dfs(TreeNode root) {
//        if (root == null)
//            return;
//        int dia = depth(root.left)+depth(root.right)-1;
//        max =  max > dia ? max : dia;
//        dfs(root.left);
//        dfs(root.right);
//    }
//
//    public  int depth(TreeNode root) {
//        if (root == null)
//            return 0;
//        return 1+Math.max(depth(root.left),depth(root.right));
//    }

//    public static void main(String[] args) {
//        Integer[] array = {4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2};
//        TreeNode root = TreeNodeUtil.arrayToTreeNode(array);
//        diameterOfBinaryTree(root);
//    }


    public static void main(String[] args) {
        MessageFormat messageFormat = new MessageFormat("Sorry, you can not upgrade to the Unified Account right now. To upgrade, you must meet the following conditions: VIP tier >=%s; spot assets >=%s USD.");
        String[] s1 = new String[]{"3","1000"};
        String res = String.format(messageFormat.toPattern(),s1);
        System.out.println(res);
    }


}
