package top100.stack;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/4/13 17:31
 */
public class MinStack {

    LinkedList<Integer> stack;
    LinkedList<Integer> minStack;
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()){
            minStack.push(val);
        }else {
            if (val < minStack.peek())
                minStack.push(val);
        }
    }

    public void pop() {
        int val = stack.pop();
        if (val == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
