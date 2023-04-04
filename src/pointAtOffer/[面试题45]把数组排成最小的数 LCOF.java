package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 贪心 字符串 排序 
// 👍 620 👎 0


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution45I {
    public String minNumber(int[] nums) {
        Queue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        for (int num : nums){
            queue.add(""+num);
        }
        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()){
            res.append(queue.poll());
        }
        return res.toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)
