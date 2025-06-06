package top100.stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/4/13 17:03
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        char[] parent = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i<parent.length; i++){
            char tmp = parent[i];
            if (stack.isEmpty()){
                stack.push(tmp);
            }else {
                char peek = stack.peek();
                if (valid(peek,tmp)){
                    stack.pop();
                }else
                    stack.push(tmp);
            }
        }
        return stack.isEmpty();
    }

    public boolean valid(char left, char right){
        if (left == '(' && right == ')')
            return true;
        if (left == '[' && right == ']')
            return true;
        if (left == '{' && right == '}')
            return true;

        return false;
    }
}
