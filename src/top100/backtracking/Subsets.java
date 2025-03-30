package top100.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/3/15 23:21
 */
public class Subsets {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums){
        DFS(nums,0);
        return res;
    }

    public void DFS(int[] nums, int start){

        res.add(new ArrayList<>(tmp));
        for (int i = start; i<nums.length; i++){
            tmp.add(nums[i]);
            DFS(nums,i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}
