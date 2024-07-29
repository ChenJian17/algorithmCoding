package layOffDays.SubSet;

import com.chenjian.cn.util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/7/8 22:43
 */
public class UniqueBST_96 {
//    public int numTrees(int n) {
//        if (n == 0)
//            return 0;
//        return DFS(1,n);
//
//    }
//
//    private int DFS(int left, int right) {
//        List<Integer> res = new ArrayList<>();
//        if (left > right){
//            return 1;
//        }
//        for (int i = left; i<=right; i++) {
//            int leftSum = DFS(left, i-1);
//            int rightSum = DFS(i+1, right);
//            res.add(leftSum*rightSum);
//        }
//        return res.stream().mapToInt(Integer::intValue).sum();
//    }


    Map<Integer,Integer> map = new HashMap<>();
    public int numTrees(int n) {
        if (n == 0 || n == 1)
            return 1;
        if (map.containsKey(n)){
            return map.get(n);
        }
        int count = 0;
        for (int i = 1; i<=n; i++) {
            int left = numTrees(i-1);
            int right = numTrees(n-i);
            count += left*right;
        }
        map.put(n,count);

        return count;

    }


    public static void main(String[] args) {
        UniqueBST_96 ob = new UniqueBST_96();
        System.out.println("res: "+ob.numTrees(3));
    }
}
