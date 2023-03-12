package com.chenjian.cn.util;

/**
 * Created by chenjian on 2021/6/13 15:52
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
    public Node(int _val,  Node _next, Node _random) {
        val = _val;
        random = _random;
        next = _next;
    }
};