package top100.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/3/30 11:20
 */
public class NQueens {

    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[] store = new int[n];
        Arrays.fill(store, -1);
        DFS(n,store,0);
        System.out.println(res);
        return res;
    }

    public void DFS(int n, int[] store, int col){
        if (col == n){
            toResList(store);
            return;
        }

        for (int i = 0; i<n; i++){
            if (!canPut(store,i,col)){
                continue;
            }
            store[col] = i;
            DFS(n, store, col+1);
            store[col] = -1;

        }
    }


    // n 表示第几行
    // store数组表示前面每行分别存的是哪个位置
    // index表示该行第几个
    public boolean canPut(int[] store, int index, int col){
        if (col == 0)
            return true;
        //[col,index]
        for (int i = 0; i < col; i++){
            if (store[i] == index)
                return false;
            if (Math.abs(col-i) == Math.abs(index-store[i]))
                return false;
        }
        return true;
    }

    public void toResList(int[] store){
        List<String> list = new ArrayList<>();
        StringBuilder template = new StringBuilder();
        for (int j = 0; j<store.length; j++){
            template.append(".");
        }
        for (int i = 0; i<store.length; i++){
            StringBuilder tmp = new StringBuilder(template);
            tmp.replace(store[i],store[i]+1,"Q");
            list.add(tmp.toString());
        }
        res.add(list);
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        nQueens.solveNQueens(4);



    }
}
