package top100.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/3/25 23:35
 */
public class GenerateParentheses {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n <= 0)
            return null;
        DFS("",0,0,n);
        return res;

    }
    public void DFS(String builder, int left, int right, int n){
        if (left > n || right > n || right > left)
            return;
        if (builder.length() == n*2){
            res.add(builder.toString());
            return;
        }
        DFS(builder+"(",left+1,right,n);
        DFS(builder+")",left,right+1,n);

    }
}
