package top100.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/3/15 22:23
 */
public class Permutations {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums){
        boolean[] flag = new boolean[nums.length];
        DFS(nums,flag,new ArrayList<>());
        return res;
    }

    public void DFS(int[] nums, boolean[] flag, List<Integer> tmp){
        if (tmp.size() == nums.length){
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i<nums.length; i++){
            if (flag[i])
                continue;
            flag[i] = true;
            tmp.add(nums[i]);
            DFS(nums, flag, tmp);
            flag[i] = false;
            tmp.remove(tmp.size()-1);
        }
    }
}
