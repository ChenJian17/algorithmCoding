package top150;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/7/10 21:16
 */
public class Roman2Integer {
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<s.length(); i++){
            int num = map.get(s.charAt(i));
            if(stack.isEmpty()){
                stack.push(num);
                continue;
            }

            if(num <= stack.peek()){
                stack.push(num);
            }else{
                int top = stack.pop();
                num -= top;
                stack.push(num);
            }

        }

        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }

        return res;

    }
}
