package com.chenjian;

import java.util.*;

public class Main {
    public class Node{
        int x;
        int y;
        int dis;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
            this.dis = x-y;
        }
    }

    public static void main(String[] args) {
        int[] dis = new int[]{3,4,8,8,3,6,8};
        int[] speed = new int[]{1,1,1,2,1,1,2};
        System.out.println(new Main().eliminateMaximum(dis, speed));

    }

    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.dis - o2.dis;
            }
        });
        for (int i=0; i<dist.length; i++)
            queue.offer(new Node(dist[i],speed[i]));
        int res = 0,min = 0;
        boolean pre = false;

        while (!queue.isEmpty()){
            if (!pre){
                Node node = queue.poll();
                pre = (node.dis-min*node.y) <= 0?true:false;
                res ++;
                min ++;
            }else {
                Node node = queue.poll();
                if ((node.dis-(min-1)*node.y) <= 0)
                    return res;
                else {
                    pre = (node.dis-min*node.y) <= 0?true:false;
                    res ++;
                    min ++;
                }
            }
        }
        return res;
    }
}
