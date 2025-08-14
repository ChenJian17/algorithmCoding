package top150;

import com.chenjian.cn.util.Node;

import java.util.*;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/7/28 16:31
 */
public class PopulatingNext {

//    public Node connect(Node root) {
//
//
//
//    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        if(s.length() != t.length())
            return false;

        int size = s.length();
        for(int i = 0; i<size; i++) {
            if (map.containsKey(s.charAt(i)) ||
                    map.containsKey(t.charAt(i))) {
                char tmp = map.get(s.charAt(i)) != null
                        ? map.get(s.charAt(i)) : map.get(t.charAt(i));
                char ans = map.get(s.charAt(i)) != null
                        ? t.charAt(i) : s.charAt(i);
                if (ans != tmp)
                    return false;

            } else {
                map.put(s.charAt(i), t.charAt(i));

            }
        }
        return true;

    }

    public static boolean wordPattern(String pattern, String s) {

        Map<Character,String> map1 = new HashMap<>();
        Map<String,Character> map2 = new HashMap<>();

        String[] arr = s.split(" ");

        if(pattern.length() != arr.length){
            return false;
        }
        int len = pattern.length();
        for(int i = 0; i<len; i++){
            if(map1.containsKey(pattern.charAt(i))&& !map1.get(pattern.charAt(i)).equals(arr[i])
                    || map2.containsKey(arr[i])&& map2.get(arr[i]) != pattern.charAt(i)){
                return false;
            }
            map1.put(pattern.charAt(i),arr[i]);
            map2.put(arr[i],pattern.charAt(i));
        }
        return true;

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        Map<String,List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String tmp = arr.toString();
            if(map.containsKey(arr.toString())){
                map.get(arr.toString()).add(s);
            }
            map.put(arr.toString(),List.of(s));
        }

        for(String key: map.keySet()){
            res.add(map.get(key));
        }
        return res;

    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        int[] arr =  new int[]{1,1};
        groupAnagrams(strs);

    }
}
