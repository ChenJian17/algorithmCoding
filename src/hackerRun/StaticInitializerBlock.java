package hackerRun;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/11/2 22:05
 */
interface PerformOperation {
    boolean check(int a);
}
public class StaticInitializerBlock {

    public static String betterCompression(String s) {
        // Write your code here
        Map<Character,Integer> map = new TreeMap<>();

        int i = 0;
        while (i < s.length()){
            char c = s.charAt(i);
            int j = i + 1;
            int x = 0;
            while (j < s.length() && Character.isDigit(s.charAt(j))) {
                x = x * 10 + (s.charAt(j) - '0');
                j++;
            }
            map.put(c,Integer.sum((Integer) map.getOrDefault(c,0),x));
            i = j;
        }
        StringBuilder ans = new StringBuilder();
        for (var e : map.entrySet()) {
            ans.append(e.getKey()).append(e.getValue());
        }
        return ans.toString();
    }

    public String betterCompression1(String compressed) {
        Map<Character, Integer> cnt = new TreeMap<>();
        int i = 0;
        int n = compressed.length();
        while (i < n) {
            char c = compressed.charAt(i);
            int j = i + 1;
            int x = 0;
            while (j < n && Character.isDigit(compressed.charAt(j))) {
                x = x * 10 + (compressed.charAt(j) - '0');
                j++;
            }
            cnt.merge(c, x, Integer::sum);
            i = j;
        }

        StringBuilder ans = new StringBuilder();
        for (var e : cnt.entrySet()) {
            ans.append(e.getKey()).append(e.getValue());
        }
        return ans.toString();
    }

}
