package top100.slidingWindow;

import java.util.*;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/8/17 21:30
 */
public class FindAllAnagramsString {

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : p.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int left = 0, right = 0;
        int valid = 0;
        List<Integer> res = new ArrayList<>();
        while (right < p.length()){
            char c = p.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c,0)+1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }
            while (right - left >= p.length()) {
                if (valid == need.size())
                    res.add(left);
                char tmp = s.charAt(left);
                if (need.containsKey(tmp)){
                    if (window.get(tmp).equals(need.get(tmp)))
                        valid--;
                    window.put(tmp, window.get(tmp)-1);
                }
            }
        }
        return res;
    }

    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> res = new ArrayList<>();
        char[] sCnt = new char[26];
        char[] pCnt = new char[26];
        int m = p.length();
        for (int i = 0; i<m; i++){
            sCnt[s.charAt(i)-'a']++;
            pCnt[s.charAt(i)-'a']++;
        }

        if (Arrays.equals(pCnt,sCnt)){
            res.add(0);
        }

        for (int i = m; i<s.length(); i++){
            sCnt[s.charAt(i-m)-'a'] --;
            sCnt[s.charAt(i)-'a'] ++;
            if (Arrays.equals(pCnt,sCnt)) {
                res.add(i-m+1);
            }
        }

        return res;
    }
}
