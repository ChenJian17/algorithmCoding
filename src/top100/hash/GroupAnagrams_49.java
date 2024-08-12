package top100.hash;

import java.util.*;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/8/10 22:22
 */
public class GroupAnagrams_49 {
    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<>();
        for (String s: strs){
            char[] tmp = s.toCharArray();
            Arrays.sort(tmp);
            map.computeIfAbsent(new String(tmp),k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(strings);
    }
}
