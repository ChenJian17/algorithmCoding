package top150;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/7/17 22:27
 */
public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while(i < s.length() && j < t.length()){
            if(t.charAt(j) == s.charAt(i)){
                j++;
                i++;
            }else {
                j++;
            }
        }
        return i == s.length()-1;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "ahbgdc";
        isSubsequence(s1,s2);
    }
}
