package top100.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/4/18 22:08
 */
public class DecodeString {

    public String decodeString(String s) {
        Deque<Integer> stack_num = new LinkedList<>();
        Deque<String> stack_res = new LinkedList<>();
        int num = 0;
        StringBuilder res = new StringBuilder();
        for (Character c : s.toCharArray()){
            if (c == '['){
                stack_num.push(num);
                stack_res.push(res.toString());
                num = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int count = stack_num.pop();
                for (int i = 0; i<count; i++){
                    tmp.append(res);
                }
                String last_res = stack_res.pop();
                res = new StringBuilder(last_res+tmp);
            }else if (c <= '9' && c >= '0'){
                num = num*10 + (c-'0');
            }else {
                res.append(c);
            }
        }

        return res.toString();
    }


//    public String decodeString(String s) {
//        char[] str = s.toCharArray();
//        Stack<String> stack = new Stack<>();
//
//        for (int i = 0; i<str.length; i++){
//            if (str[i] == ']'){
//                StringBuilder tmp = new StringBuilder();
//                while (!stack.peek().equals("[")){
//                    tmp.append(stack.pop());
//                }
//                tmp.reverse();
//                //弹出 [
//                stack.pop();
//                int num = Integer.parseInt(stack.pop());
//                StringBuilder stock = expansion(tmp,num);
//                stack.push(stock.toString());
//
//            } else {
//                stack.push(String.valueOf(str[i]));
//            }
//        }
//
//        StringBuilder ans = new StringBuilder();
//
//        for (int i = 0; i<stack.size(); i++){
//            ans.append(stack.get(i));
//        }
//        return ans.toString();
//
//    }
//
//    public StringBuilder expansion(StringBuilder tmp, int count){
//        StringBuilder stock = new StringBuilder();
//        while (count > 0){
//            stock.append(tmp);
//            count--;
//        }
//        return stock;
//    }

    public static void main(String[] args) {
        String input = "3[a2[c]]";
        DecodeString decodeString =  new DecodeString();
        decodeString.decodeString(input);
    }
}
