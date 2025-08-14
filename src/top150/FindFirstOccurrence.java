package top150;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/7/13 10:41
 */
public class FindFirstOccurrence {

    public int strStr(String haystack, String needle) {

        int left = 0;

        int len1 = haystack.length();
        int len2 = needle.length();

        while(left <= (len1-len2)){
            if(haystack.charAt(left) == needle.charAt(0)){
                if(compare(haystack,needle,left)){
                    return left;
                }
            }
            left ++;
        }
        return -1;

    }

    public boolean compare(String s1, String s2, int index){
        int i = 0;
        while(i < s2.length()){
            if(s1.charAt(index) == s2.charAt(i)){
                i ++;
                index ++;
            }else{
                return false;
            }
        }
        return true;

    }
}
