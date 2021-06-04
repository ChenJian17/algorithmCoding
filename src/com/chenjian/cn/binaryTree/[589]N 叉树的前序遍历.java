package com.chenjian.cn.binaryTree;//给定一个 N 叉树，返回其节点值的 前序遍历 。
//
// N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。 
//
// 
// 
// 
//
// 进阶： 
//
// 递归法很简单，你可以使用迭代法完成此题吗? 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[1,3,5,6,2,4]
// 
//示例 2：
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
// 
//
// 
//
// 提示： 
//
// 
// N 叉树的高度小于或等于 1000 
// 节点总数在范围 [0, 10^4] 内 
// 
// 
// 
// Related Topics 树 
// 👍 159 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Node5 {
    public int val;
    public List<Node5> children;

    public Node5() {}

    public Node5(int _val) {
        val = _val;
    }

    public Node5(int _val, List<Node5> _children) {
        val = _val;
        children = _children;
    }
};


class Solution589 {
    public List<Integer> preorder(Node5 root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
        
    }
    void traversal(Node5 root, List<Integer> result){
        if (root == null)
            return;
        result.add(root.val);
        for (Node5 node: root.children){
            traversal(node, result);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
