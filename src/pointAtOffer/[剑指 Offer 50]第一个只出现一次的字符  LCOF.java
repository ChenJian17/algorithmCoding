package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 队列 哈希表 字符串 计数 
// 👍 309 👎 0


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution50 {
    public char firstUniqChar1(String s) {
        Map<Character,Boolean> map = new HashMap<>();
        for (int i =0; i<s.length(); i++) {
            map.put(s.charAt(i), !map.containsKey(s.charAt(i)));
        }
        for (int i =0; i<s.length(); i++) {
            if (map.get(s.charAt(i))){
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public char firstUniqChar2(String s){
        Map<Character,Boolean> map = new LinkedHashMap<>();
        for (int i =0; i<s.length(); i++) {
            map.put(s.charAt(i), !map.containsKey(s.charAt(i)));
        }
        for (Map.Entry<Character,Boolean> item : map.entrySet()) {
            if (item.getValue()) {
                return item.getKey();
            }
        }
        return ' ';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
