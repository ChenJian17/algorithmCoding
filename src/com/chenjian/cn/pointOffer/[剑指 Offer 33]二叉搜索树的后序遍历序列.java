package com.chenjian.cn.pointOffer;//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// 👍 220 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution33 {
    public boolean verifyPostorder(int[] postorder) {
        return find(postorder, 0, postorder.length-1);

    }

    public boolean find(int[] postorder, int i, int j){
        if(i >= j) return true;  //表示该子树只有一个节点或者没有节点
        int m = i;
        while (postorder[m] < postorder[j]){
            m++;

        }
        int p = m;        //此时p为中间节点
        while (postorder[m] > postorder[j]){
            m++;
        }

        return m == j && find(postorder, i, p-1) && find(postorder, p, j);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
