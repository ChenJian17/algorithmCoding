package top100.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/3/22 21:13
 */
public class CombinationSum {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        DFS(candidates, 0, 0, target, new ArrayList<>());
        return res;

    }

    public void DFS(int[] candidates, int cur, int sum, int target, List<Integer> tmp){
        if (sum == target){
            res.add(new ArrayList<>(tmp));
            return;
        }
        if (sum > target){
            return;
        }

        for (int i = cur; i<candidates.length; i++){

            sum += candidates[i];
            if (sum > target)
                continue;
            tmp.add(candidates[i]);
            DFS(candidates, i, sum, target, tmp);
            tmp.remove(tmp.size()-1);
            sum -= candidates[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,6,7};
        CombinationSum sum = new CombinationSum();
        sum.combinationSum(arr, 7);
    }
}
