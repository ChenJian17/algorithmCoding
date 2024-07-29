package layOffDays.SubSet;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/7/4 20:47
 */
public class Permutations_46 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int[] used = new int[nums.length];
        dfs(0,nums,used);
        return ans;
    }

    private void dfs(int next, int[] nums, int[] used) {
        if (next == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1)
                continue;
            used[i] = 1;
            path.add(nums[i]);
            dfs(++next, nums, used);
            next --;
            used[i] = 0;
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        Permutations_46 permutations = new Permutations_46();
        List<List<Integer>> fin = permutations.permute(arr);
        for (List<Integer> tmp : fin) {
            System.out.println(tmp);
        }
    }
}
