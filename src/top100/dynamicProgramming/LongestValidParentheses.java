package top100.dynamicProgramming;

import java.util.Stack;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/6/14 15:23
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int res = 0;

        for (int i = 0; i<s.length(); i++){
            if (s.charAt(i) == '('){
                stack.push(i);
            }else if (s.charAt(i) == ')'){
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else {
                    res = Math.max(res,i-stack.peek());
                }
            }
        }
        return res;
    }

    public int longestValidParentheses1(String s){
        int maxLen = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i<s.length(); i++){
            if (s.charAt(i) == ')'){
                if (s.charAt(i-1) == '('){
                    dp[i] = (i >= 2 ? dp[i-2] : 0)+2;
                }else if (i-dp[i-1]>0 && s.charAt(i-dp[i-1]-1) == '('){
                    dp[i] = dp[i-1] + (i-dp[i-1]>=2 ? dp[i-dp[i-1]-2]:0)+2;
                }
                maxLen = Math.max(maxLen,dp[i]);
            }
        }
        return maxLen;
    }
}
