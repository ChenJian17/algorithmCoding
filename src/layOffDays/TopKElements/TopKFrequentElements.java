package layOffDays.TopKElements;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/7/26 23:59
 */
public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1)-map.get(o2);
            }
        });

        for (Integer key: map.keySet()) {
            if (queue.size() < k){
                queue.offer(key);
            }else if (map.get(key) > map.get(queue.peek())){
                queue.poll();
                queue.offer(key);
            }
        }

        int[] ans = new int[k];
        int i = 0;
        while (!queue.isEmpty()){
            ans[i] = queue.poll();
        }
        return ans;


    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,3,1,1,1,3,73,1};
        topKFrequent(arr,2);
    }
}
