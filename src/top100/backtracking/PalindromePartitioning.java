package top100.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/3/27 20:35
 */
public class PalindromePartitioning {

    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {

        DFS(0,0,s,new ArrayList<>());
        return res;

    }

    public void DFS(int begin, int end, String str, List<String> path){
        if (end == str.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        begin = end;
        for (int i = end; i<=str.length(); i++){

            String tmp = str.substring(begin,i);
            if (!isPalindrome(tmp)){
                continue;
            }
            path.add(tmp);
            DFS(begin,i, str, path);
            path.remove(path.size()-1);
        }
    }



    public boolean isPalindrome(String str){
        if (str.equals(""))
            return false;
        if (str.length() == 1)
            return true;
        int left = 0, right = str.length()-1;
        while (left < right){
            if (str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right --;
        }
        return true;

    }

    public static void main(String[] args) {
        String s = "abbab";
//        System.out.println(s.substring(2,3));
        PalindromePartitioning partitioning = new PalindromePartitioning();
        partitioning.partition(s);
    }
}
