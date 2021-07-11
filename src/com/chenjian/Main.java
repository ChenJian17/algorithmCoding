package com.chenjian;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        String s = "bbcbaba";
        new Main().countPalindromicSubsequence(s);
    }


    int count = Integer.MAX_VALUE;
    public int nearestExit(char[][] maze, int[] entrance) {
        boolean[][] flag = new boolean[maze.length][maze[0].length];
        flag[entrance[0]][entrance[1]] = true;
        DFS(flag,maze,entrance[0],entrance[1],0,entrance);
        System.out.println(count);
        return count == Integer.MAX_VALUE ?-1:count;


    }

    public void DFS(boolean[][] flag,char[][] maze, int i, int j, int path,int[] entrance){

        if(i != entrance[0] || j != entrance[1]){
            if (i>maze.length || i<0 || j>maze[0].length || j<0 ){
                if (!flag[i][j])
                   return;
            }
        }

        if (i != entrance[0] || j != entrance[1]){
            if (i == 0 || i==maze.length-1 || j==0 || j==maze[0].length-1){
                if (i>=0&&i<=maze.length-1 && j>=0&&j<=maze[0].length-1 ){
                    if (maze[i][j] == '.')
                        count = Math.min(count,path);
                }


                return;
            }
        }
        if (maze[i][j] == '.')
            flag[i][j] = true;
        else
            return;

        DFS(flag,maze,i+1,j,path+1,entrance);
        DFS(flag,maze,i,j+1,path+1,entrance);
        DFS(flag,maze,i-1,j,path+1,entrance);
        DFS(flag,maze,i,j-1,path+1,entrance);

    }


    public int countPalindromicSubsequence(String s) {
        Set<String> set = new HashSet<>();
        int flag = -1;
        int k=0;
        for (int i=0; i<s.length()-2; i++){
            flag = 1;
            for (int j=i+2; j<s.length(); j++){
                if (s.charAt(i) == s.charAt(j)){
                    if (flag == 1)
                        k = i+1;
                    while (k<j){
                        String ans = String.valueOf(new char[]{s.charAt(i),s.charAt(k),s.charAt(j)});
                        set.add(ans);
                        k++;
                    }
                    flag = -1;
                }

            }
        }
        int count = 0;
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            count ++;
            iterator.next();
        }
        return count;

    }





}
