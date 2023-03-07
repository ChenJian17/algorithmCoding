package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 栈 设计 队列 
// 👍 713 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class CQueue {

    Stack<Integer> stack1, stack2 ;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void appendTail(int value) {
        stack1.push(value);

    }
    
    public int deleteHead() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        if (stack1.isEmpty()){
            return -1;
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();

    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)
