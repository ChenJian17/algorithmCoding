package top100.stack;

import java.util.Stack;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/4/20 23:35
 */
public class DailyTemperatures {

    class Pair {
        int key;
        int val;
        public Pair(int key, int val){
            this.key = key;
            this.val = val;
        }
        public int getKey() {
            return key;
        }
        public int getVal() {
            return val;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Pair> stack = new Stack<>();

        int[] res = new int[temperatures.length];

        for (int i = 0; i<temperatures.length; i++){
            while (!stack.isEmpty() && temperatures[i] > stack.peek().getVal()){
                int index = stack.peek().getKey();
                res[index] = i-index;
                stack.pop();

            }
            stack.push(new Pair(i,temperatures[i]));
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{73,74,75,71,69,72,76,73};

        DailyTemperatures daily = new DailyTemperatures();
        daily.dailyTemperatures(arr);
    }

    //[73,74,75,71,69,72,76,73]

}
