package layOffDays.KWaymerge;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/8/6 22:13
 */
public class SmallestNumberRange_632 {
    public int[] smallestRange(List<List<Integer>> nums) {

//        int left = Integer.MIN_VALUE;
//        int right = Integer.MAX_VALUE;
//        int max = -1;
        int max = Integer.MIN_VALUE;
        int left = Integer.MIN_VALUE/3;
        int right = Integer.MAX_VALUE/3;

        Queue<Pair> queue = new PriorityQueue<>((a,b) -> a.val-b.val);
        for (int i = 0; i<nums.size(); i++){
            List<Integer> node = nums.get(i);
            queue.offer(new Pair(node.get(0),i,0));
            max = Math.max(node.get(0),max);
        }

        while (queue.size() == nums.size()) {
            Pair node = queue.poll(); //最小

            if ((max-node.val) < (right-left)){
                right = max;
                left = node.val;
            }

            if (node.post+1 < nums.get(node.index).size()) {
                Integer tmp = nums.get(node.index).get(node.post+1);
                queue.offer(new Pair(tmp, node.index, node.post+1));
                max = Math.max(tmp,max);
            }
        }

        return new int[]{left,right};

    }


    static class Pair {
        int index; //在哪个数组
        int post; // 在哪个位置
        int val;

        public Pair(int value, int i, int j){
            this.val = value;
            this.index = i;
            this.post = j;
        }
    }
}
