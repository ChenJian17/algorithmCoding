package top100.dynamicProgramming;

import java.util.Arrays;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/5/7 11:59
 */
public class ClimbStairs {

    int count = 0;
    int[] arr = new int[46];
    public int climbStairs(int n) {
//        DFS(n);
        Arrays.fill(arr,-1);
//        return count;
        return DFS1(n);

    }
//
//    public void DFS(int n){
//
//        if (n <= 0){
//            if (n == 0)
//                count++;
//            return;
//        }
//
//        if (arr[n] != -1){
//            count = count+arr[n];
//            return;
//        }
//
//        DFS(n-1);
//        DFS(n-2);
//    }

    public int DFS1(int n){

        if (n <= 0){
            if (n == 0)
                return 1;
            return 0;
        }

        if (arr[n] != -1){
            return arr[n];
        }
        int left = DFS1(n-1);
        int right = DFS1(n-2);

        arr[n] = left+right;
        return left+right;
    }

    public static void main(String[] args) {
        ClimbStairs stairs = new ClimbStairs();
//        stairs.climbStairs(3);
        System.out.println(stairs.climbStairs(44));
    }
}
