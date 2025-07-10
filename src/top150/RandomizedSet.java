package top150;

import java.util.*;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/7/6 15:28
 */
public class RandomizedSet {

    List<Integer> nums;
    Map<Integer,Integer> map;
    Random random;

    public RandomizedSet() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        int index = nums.size();
        map.put(val,index);
        nums.add(val);
        return true;

    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }

        int last = nums.get(nums.size()-1);
        int index = map.get(val);
        nums.set(index,last);
        nums.remove(nums.size()-1);

        map.put(last,index);
        map.remove(val);

        
        return true;
    }

    public int getRandom() {
        int randomValue = random.nextInt(nums.size());
        return nums.get(randomValue);

    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println("remove: "+randomizedSet.remove(0));
        System.out.println("remove: "+randomizedSet.remove(0));
        System.out.println("insert: "+randomizedSet.insert(0));
        System.out.println("random: "+randomizedSet.getRandom());
        System.out.println("remove: "+randomizedSet.remove(0));
        System.out.println("insert: "+randomizedSet.insert(0));
    }
}
