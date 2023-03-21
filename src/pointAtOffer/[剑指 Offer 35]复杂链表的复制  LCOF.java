package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 哈希表 链表 
// 👍 692 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Map<Node,Node> map = new HashMap<>();
        Node dum = new Node(0);
        Node pre = dum;
        Node cur = head;
        while (cur != null) {
            Node tmp = new Node(cur.val);
            map.put(cur,tmp);
            pre.next = tmp;
            pre = tmp;
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            Node newNode = map.get(cur);
            Node random = cur.random;
            Node val = map.get(random);
            newNode.random = val;
            cur = cur.next;
        }
        return dum.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
