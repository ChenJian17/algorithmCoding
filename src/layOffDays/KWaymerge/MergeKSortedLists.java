package layOffDays.KWaymerge;


import com.chenjian.cn.util.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/8/2 17:47
 */
public class MergeKSortedLists {

//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists == null || lists.length == 0)
//            return null;
//        Queue<ListNode> queue = new PriorityQueue<>((o1, o2) -> {
//            return o1.val-o2.val;
//        });
//        ListNode dump = new ListNode(0);
//        ListNode p = dump;
//        for (ListNode node: lists){
//            if (node != null)
//                queue.add(node);
//        }
//        while (!queue.isEmpty()) {
//            p.next = queue.poll();
//            p = p.next;
//            if (p.next != null)
//                queue.add(p.next);
//        }
//        return dump.next;
//    }

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length-1);
    }

    public ListNode merge(ListNode[] lists, int l, int r){
        if (l == r)
            return lists[l];
        if (l > r)
            return null;
        int mid = (l+r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));

    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null){
            return a == null ? b : a;
        }

        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null){
            if (aPtr.val < bPtr.val){
                tail.next = aPtr;
                aPtr = aPtr.next;
            }else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;

    }
}
