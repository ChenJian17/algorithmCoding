package top100.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/4/25 19:32
 */
public class TopKElements {

    public int[] topKFrequent(int[] nums, int k){
        Map<Integer,Integer> map = new HashMap<>();
        for (int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Map.Entry> queue = new PriorityQueue<>(new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                return (int) o1.getValue() - (int) o2.getValue();
            }
        });

        for (Map.Entry<Integer,Integer> entry: map.entrySet()){
            if (queue.size() < k){
                queue.add(entry);
            }else {
                if (entry.getValue() > (int)queue.peek().getValue()){
                    queue.poll();
                    queue.offer(entry);
                }

            }
        }
        int[] res = new int[k];
        int index = 0;
        while (!queue.isEmpty()){
            Map.Entry<Integer,Integer> entry = queue.poll();
            res[index] = entry.getKey();
            index ++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        TopKElements topKElements = new TopKElements();
        topKElements.topKFrequent(nums, k);
    }
}
