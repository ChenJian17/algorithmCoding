package layOffDays.SubSet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/7/1 22:39
 */
public class Subsets_78 {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();


    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return res;
    }

    private void dfs(int startIndex, int[] nums) {
        printPath(startIndex, path);
        res.add(new ArrayList<>(path));
        for (int i = startIndex; i<nums.length; i++) {
            path.add(nums[i]);
            dfs(i+1,nums);
            path.removeLast();
        }
    }

    private void printPath(int startIndex,LinkedList<Integer> path){
        System.out.print(startIndex+" ");
        System.out.println(path);
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3};
        Subsets_78 cl = new Subsets_78();
        List<List<Integer>> fin = cl.subsets(test);
//        for (List<Integer> tmp : fin) {
//            System.out.println(tmp);
//        }
    }
}
