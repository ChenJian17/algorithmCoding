package layOffDays.SubSet;

import java.util.*;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/7/2 22:12
 */
public class SubsetsII_90 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int[] used = new int[nums.length];

        dfs(0, nums, used);
        return res;
    }

    private void dfs(int index, int[] nums, int[] used) {
        res.add(new ArrayList<>(path));

        for (int i = index; i<nums.length; i++) {
            // 1.树层去重
            // 2.因为是nums[i] == nums[i-1]相同元素彼此邻近，所以需要排序
            // 3.从递归树的角度看，同一层某个元素的选取是上一位元素递归时回溯而来，上一位元素回溯即不取，used[i-1] = 0
            if (i != 0 && nums[i] == nums[i-1] && used[i-1] == 0){
                continue;
            }
            used[i] = 1; // 不确定这个位置的元素取不取，所以应该放在continue之后
            path.add(nums[i]);
            dfs(i+1, nums, used);
            path.remove(path.size()-1);
            used[i] = 0; //递归栈弹出，设为0
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,4,4,1,4};
        SubsetsII_90 su = new SubsetsII_90();
        List<List<Integer>> fin = su.subsetsWithDup(arr);
        for (List<Integer> tmp : fin) {
            System.out.println(tmp);
        }
    }
}
