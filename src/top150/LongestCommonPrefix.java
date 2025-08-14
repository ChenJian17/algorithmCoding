package top150;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/7/12 20:41
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int index = 0;

        String res = "";
        if (strs.length <= 1){
            return strs[0];
        }

        while(true){
            char tmp = '0';
            for(int i = 0; i<strs.length; i++){
                if (strs[i].equals(""))
                    return "";
                if (strs[i].length() <= index){
                    return res;
                }
                if(i == 0){
                    tmp = strs[i].charAt(index);
                    continue;
                }
                if(tmp != strs[i].charAt(index)){
                    return res;
                }
            }
            res += tmp;
            
            index ++;
        }


    }

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = new String[]{"flower","flow","flight"};
        lcp.longestCommonPrefix(strs);

    }
}
