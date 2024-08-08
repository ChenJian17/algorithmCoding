package layOffDays.KWaymerge;

import java.util.*;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/8/7 23:16
 */
public class FindKPairsSmallestSums_373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        Queue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return (o2.post+o2.index)-(o1.post+o1.index);

            }
        });

        for (int i = 0; i<nums1.length; i++){
            for (int j = 0; j<nums2.length; j++){
                if (queue.size() <= k) {
                    queue.offer(new Pair(nums1[i],nums2[j]));
                }else {
                    queue.poll();
                    queue.offer(new Pair(nums1[i],nums2[j]));
                }
            }
        }
        while (queue.size() > k){
            queue.poll();
        }

        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            res.add(List.of(pair.index,pair.post));
        }

        System.out.println(res);
        return res;

    }
    static class Pair {
        int index;
        int post;

        public Pair(int index, int post){
            this.index = index;
            this.post = post;
        }
    }

    public static void main(String[] args) {
        FindKPairsSmallestSums_373 o = new FindKPairsSmallestSums_373();
        int[] nums1 = new int[]{1,1,2};
        int[] nums2 = new int[]{1,2,3};
        o.kSmallestPairs(nums1,nums2,2);
    }
}
