package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 栈 树 深度优先搜索 二叉搜索树 链表 二叉树 双向链表 
// 👍 667 👎 0


import com.chenjian.cn.util.Node;

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution36 {
    Node head = null, pre = null;
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return root;
        helper(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void helper(Node root){
        if (root == null)
            return;
        helper(root.left);
        if (pre == null){
            head = root;
        }else {
            pre.right = root;
        }
        root.left = pre;
        pre = root;
        helper(root.right);
    }

    private static final ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new MyThread(i));
            thread.start();
        }
    }
    static class MyThread implements Runnable {
        private int index;

        public MyThread(int index) {
            this.index = index;
        }

        public void run() {
            System.out.println("线程" + index + "的初始value:" + value.get());
            for (int i = 0; i < 10; i++) {
                value.set(value.get() + i);
            }
            System.out.println("线程" + index + "的累加value:" + value.get());
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
