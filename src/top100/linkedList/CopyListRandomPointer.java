package top100.linkedList;

import com.chenjian.cn.util.ListNode;
import com.chenjian.cn.util.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/9/30 23:02
 */
public class CopyListRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        // 1.在每个原节点后面创建一个新节点
        Node point = head;
        while (point != null){
            Node newNode = new Node(point.val);
            newNode.next = point.next;
            point.next = newNode;
            point = point.next.next;
        }

        // 2.设置新节点的随机节点
        point = head;
        while (point != null){
            if (point.random != null){
                point.next.random = point.random.next;
            }
            point = point.next.next;
        }

        // 3.将两个链表分离
        Node dump = new Node(-1);
        Node cur = dump;
        point = head;
        while (point != null){
            cur.next = point.next;
            cur = cur.next;
            point.next = cur.next;
            point = point.next;
        }
        return dump.next;




    }
}
