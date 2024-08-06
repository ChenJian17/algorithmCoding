package layOffDays.TopKElements;

import java.util.*;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/8/1 21:38
 */
public class FreqStack {

    Map<Integer,Integer> map = new HashMap<>();

    List<Deque<Integer>> stacks = new ArrayList<>();


    public FreqStack() {

    }

    public void push(int val) {
        int count = map.getOrDefault(val,0);
        if (count == stacks.size()){
            stacks.add(new ArrayDeque<>());
        }
        stacks.get(count).push(val);
        map.put(val,count+1);
    }

    public int pop() {
        int maxCount = stacks.size()-1;
        int val = stacks.get(maxCount).pop();
        if (stacks.get(maxCount).isEmpty()){
            stacks.remove(maxCount);
        }
        map.put(val, map.get(val)-1);
        return val;

    }
}
