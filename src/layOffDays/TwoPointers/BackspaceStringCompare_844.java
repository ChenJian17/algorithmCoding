package layOffDays.TwoPointers;

import java.util.Stack;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/9/11 22:48
 */
public class BackspaceStringCompare_844 {
    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (int i = 0; i<s.length(); i++) {
            if (s.charAt(i) != '#') {
                stack1.add(s.charAt(i));
            }else {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            }
        }
        for (int i = 0; i<t.length(); i++) {
            if (t.charAt(i) != '#') {
                stack2.add(t.charAt(i));
            }else {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            }
        }
        if (stack1.size() != stack2.size())
            return false;
        if (stack1.isEmpty() && stack2.isEmpty())
            return true;
        while (!stack2.isEmpty() && !stack1.isEmpty()) {
            char s1 = stack1.pop();
            char s2 = stack2.pop();
            if (s1 != s2)
                return false;
        }
        return true;


    }

//    public static boolean backspaceCompare1(String s, String t) {
//        int skipS = 0, skipT = 0;
//        int i = s.length()-1, j = t.length()-1;
//        for () {
//
//            if (s.charAt(i) == '#') {
//                skipS++;
//                i--;
//            }else if (skipS != 0) {
//                i--;
//                skipS--;
//            }else if (skipS == 0) {
//                char c = s.charAt(i);
//            }
//
//
//        }
//
//    }
    public static boolean backspaceCompare1(String s, String t) {
        return convert(s).equals(convert(t));
    }

    public static String convert(String s) {
        StringBuilder sb = new StringBuilder();
        char[] cs = s.toCharArray();
        int size = 0;
        for (int i = cs.length-1; i>=0; i--) {
            if (cs[i] == '#') {
                size++;
            }else if (size == 0) {
                sb.append(cs[i]);
            }else {
                size --;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "xywrrmp", s2 = "xywrrmu#p";
        backspaceCompare(s1,s2);
    }
}
