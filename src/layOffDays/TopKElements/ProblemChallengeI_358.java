package layOffDays.TopKElements;

import java.util.*;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/7/30 21:32
 */
public class ProblemChallengeI_358 {

    public String rearrangeString(String s, int k) {
        if (k <= 1)
            return s;
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());
        for (Character c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        maxHeap.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();

        Queue<Map.Entry<Character,Integer>> queue = new LinkedList<>();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character,Integer> entry = maxHeap.poll();
            sb.append(entry.getKey());
            entry.setValue(entry.getValue()-1);
            queue.offer(entry);
            if (queue.size() == k){
                Map.Entry<Character,Integer> tmp = queue.poll();
                if (tmp.getValue() > 0){
                    maxHeap.offer(tmp);
                }

            }
        }

        return sb.length() == s.length() ? sb.toString() : "";

    }
}
