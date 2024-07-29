package layOffDays.TopKElements;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/7/27 10:57
 */
public class FrequencySort_451 {

    public String frequencySort(String s) {
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c: arr) {
            map.put(c, map.getOrDefault(c,0)+1);
        }

        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o1)-map.get(o2);
            }
        });


        for (Character key: map.keySet()) {
            queue.offer(key);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            for (int i = 0; i<map.get(c); i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
