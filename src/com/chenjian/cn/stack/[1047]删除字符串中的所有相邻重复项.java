package com.chenjian.cn.stack;//给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
//
// 在 S 上反复执行重复项删除操作，直到无法继续删除。 
//
// 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。 
//
// 
//
// 示例： 
//
// 输入："abbaca"
//输出："ca"
//解释：
//例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又
//只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 20000 
// S 仅由小写英文字母组成。 
// 
// Related Topics 栈 
// 👍 211 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1047 {
    public static String removeDuplicates(String S) {
        char[] array = S.toCharArray();
        Deque<Character> result = new LinkedList<>();
        result.push(array[0]);
        for(int i = 1; i < array.length; i ++){
            if(result.peek() == null){
                result.push(array[i]);
                continue;
            }
            if(array[i] == result.peek()){
                result.pop();
            }else {
                result.push(array[i]);
            }
        }
        char[] temp = new char[result.size()];
        int length = result.size();
        while(result.peek() != null){
            temp[--length] = result.pop();
        }
        return String.valueOf(temp);

    }

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
