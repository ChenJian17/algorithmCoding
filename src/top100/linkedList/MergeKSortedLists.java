package top100.linkedList;

import com.chenjian.cn.util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/10/3 17:38
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (ListNode node: lists){
            while (node != null){
                queue.offer(node);
                ListNode pre = node;
                node = node.next;
                pre.next = null;
            }
        }

        ListNode dump = new ListNode();
        ListNode cur = dump;
        while (!queue.isEmpty()){
            cur.next = queue.poll();
            cur = cur.next;
        }

        return dump.next;
    }
}
