package layOffDays.SubSet;

import com.chenjian.cn.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/7/7 16:41
 */
public class UniqueBSTII_95 {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        return helper(1,n);
    }

    private List<TreeNode> helper(int left, int right) {
        List<TreeNode> res = new ArrayList<>();
        if (left > right) {
            res.add(null);
            return res;
        }
        if (left == right) {
            TreeNode node = new TreeNode(left);
            res.add(node);
            return res;
        }


        for (int i = left; i <= right; i++){
            List<TreeNode> leftList = helper(left,i-1);
            List<TreeNode> rightList = helper(i+1,right);
            for (TreeNode node1 : leftList) {
                for (TreeNode node2 : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = node1;
                    root.right = node2;
                    res.add(root);
                }
            }

        }
        return res;
    }


    public static void main(String[] args) {
        UniqueBSTII_95 ob = new UniqueBSTII_95();


    }
}
