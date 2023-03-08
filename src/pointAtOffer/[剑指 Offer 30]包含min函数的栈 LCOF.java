package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 栈 设计 
// 👍 454 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

    Stack<Integer> stack1, stack2;
    /** initialize your data structure here. */
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();

    }
    
    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || x <= stack2.peek()) {
            stack2.push(x);
        }
    }
    
    public void pop() {
        if (stack1.peek() .equals(stack2.peek()) ) {
            stack2.pop();
        }
        stack1.pop();
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int min() {
        return stack2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)
