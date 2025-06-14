package top100.dynamicProgramming;

import java.util.*;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/6/5 10:36
 */
public class WordBreak {

      // 回溯
//    public boolean wordBreak(String s, List<String> wordDict) {
//        return DFS(s,wordDict,0);
//    }
//
//    public boolean DFS(String s, List<String> wordDict, int index) {
//        if(index == s.length())
//            return true;
//
//        for(int i = index+1; i<=s.length(); i++){
//            String tmp = s.substring(index,i);
//            if(wordDict.contains(tmp) && DFS(s,wordDict,i)){
//                return true;
//            }
//        }
//        return false;
//    }

     //记忆化
//    Map<Integer,Boolean> map = new HashMap<>();
//    public boolean wordBreak(String s, List<String> wordDict) {
//
//        return DFS(s,wordDict,0);
//    }
//
//    public boolean DFS(String s, List<String> wordDict, int index) {
//        if(index == s.length())
//            return true;
//
//        if(map.containsKey(index)){
//            return map.get(index);
//        }
//
//        for(int i = index+1; i<=s.length(); i++){
//            String tmp = s.substring(index,i);
//            if(wordDict.contains(tmp) && DFS(s,wordDict,i)){
//                map.put(index,true);
//                return true;
//            }
//
//        }
//
//        map.put(index,false);
//
//        return false;
//    }

    //动态规划
    public boolean wordBreak(String s, List<String> wordDict) {

        int maxlen = 0;
        for (String word: wordDict){
            maxlen = Math.max(maxlen,word.length());
        }
        Set<String> set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for (int i = 1; i<=s.length(); i++){
            for (int j = i-1; j>=Math.max(i-maxlen,0);j--){
                String tmp = s.substring(j,i);
                if (set.contains(tmp) && dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];

    }

    public static void main(String[] args) {

        Map<Integer,String> map = new HashMap<>();

        String sb = "leetcode";
        List<String> wordDict = List.of("leet","code");
        WordBreak wordBreak = new WordBreak();
//        wordBreak.wordBreak(sb, wordDict);
    }
}
