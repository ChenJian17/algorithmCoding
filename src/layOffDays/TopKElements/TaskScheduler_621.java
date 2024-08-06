package layOffDays.TopKElements;

import java.util.*;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/7/30 21:30
 */
public class TaskScheduler_621 {

    public static int leastInterval(char[] tasks, int n) {
        if (n<1)
            return tasks.length;

        Map<Character,Integer> map = new HashMap<>();
        for (char c: tasks) {
            map.put(c,map.getOrDefault(c,0)+1);
        }

        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());
        maxHeap.addAll(map.entrySet());

        Queue<Map.Entry<Character,Integer>> queue = new LinkedList<>();

        int res = 0;
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character,Integer> entry = maxHeap.poll();
            entry.setValue(entry.getValue()-1);
            queue.offer(entry);
            res++;
            if (queue.size() == (n+1)){
                while (!queue.isEmpty()) {
                    Map.Entry<Character,Integer> tmp = queue.poll();
                    if (tmp.getValue() > 0){
                        maxHeap.offer(tmp);
                    }
                }
            }else if (maxHeap.isEmpty() && queue.size() < (n+1)){
                int count = (n+1)-queue.size();
                res += count;

                while (!queue.isEmpty()) {
                    Map.Entry<Character,Integer> tmp = queue.poll();
                    if (tmp.getValue() > 0){
                        maxHeap.offer(tmp);
                    }
                }
                if (maxHeap.isEmpty()) {
                    res -= count;
                }

            }

        }

        return res;


    }

    public static void main(String[] args) {
        char[] tasks = new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'};
        System.out.println(leastInterval(tasks, 2));

    }

}
