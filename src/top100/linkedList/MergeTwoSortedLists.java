package top100.linkedList;

import com.chenjian.cn.util.ListNode;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/9/24 21:31
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null)
            return null;
        if (list1 == null || list2 == null)
            return list1 == null ? list2 : list1;

        ListNode dump = new ListNode(Integer.MIN_VALUE);
        ListNode res = dump;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                dump.next = list1;
                list1 = list1.next;
            }else {
                dump.next = list2;
                list2 = list2.next;
            }
            dump = dump.next;
        }

        if (list1 != null){
            dump.next = list1;
        }
        if (list2 != null){
            dump.next = list2;
        }

        return res.next;
    }
}
