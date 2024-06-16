package layOffDays.TreeDepthFirstSearch;

import com.chenjian.cn.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/4/1 21:46
 */
public class BinaryTreePaths_257 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        trace(root);
        List<String> ans = new ArrayList<>();
        for (List<Integer> list : res) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i<list.size(); i++) {
                builder.append(list.get(i));
                if (i != list.size()-1)
                    builder.append("->");

            }
            ans.add(builder.toString());
        }
        return ans;
    }

    public void trace(TreeNode root) {
        if (root == null)
            return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        trace(root.left);
        trace(root.right);
        path.remove(path.size()-1);
    }



    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root,"", res);
        return res;
    }

    public void dfs(TreeNode root, String path, List<String> res){
        if (root == null) {
            return;
        }
        path += root.val;
        if (root.left == null && root.right == null) {
            res.add(path);
        }

        dfs(root.left, path+"->", res);
        dfs(root.right, path+"->", res);

    }


}
