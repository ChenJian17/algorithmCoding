package com.chenjian.cn.stack;//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2260 👎 0


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution20 {
    public static boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        char[] array = s.toCharArray();
        String[] list = new String[array.length];
        for (int i =0; i<array.length; i++){
            list[i] = Character.toString(array[i]);
        }
        for (int i =0; i<list.length; i++){
            if (stack.isEmpty()){
                stack.push(list[i]);
                continue;
            }
            String temp = stack.peek();
            if (temp.equals("(")){
                if (list[i].equals(")")){
                    stack.pop();
                }else {
                    stack.push(list[i]);
                }
            }
            if (temp.equals("[")){
                if (list[i].equals("]")){
                    stack.pop();
                }else {
                    stack.push(list[i]);
                }
            }
            if (temp.equals("{")){
                if (list[i].equals("}")){
                    stack.pop();
                }else {
                    stack.push(list[i]);
                }
            }
        }
        return stack.isEmpty();

    }

    //第二种方法
    public static boolean isValid2(String s){
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        for (char c: array){
            if (c == '('){
                stack.push(')');
            }else if (c == '{'){
                stack.push('}');
            }else if (c == '['){
                stack.push(']');
            }else if (stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
