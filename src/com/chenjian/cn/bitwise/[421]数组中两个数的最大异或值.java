package com.chenjian.cn.bitwise;//给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
//
// 进阶：你可以在 O(n) 的时间解决这个问题吗？ 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [3,10,5,25,2,8]
//输出：28
//解释：最大运算结果是 5 XOR 25 = 28. 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,4]
//输出：6
// 
//
// 示例 4： 
//
// 
//输入：nums = [8,10,2]
//输出：10
// 
//
// 示例 5： 
//
// 
//输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
//输出：127
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 104 
// 0 <= nums[i] <= 231 - 1 
// 
// 
// 
// Related Topics 位运算 字典树 
// 👍 314 👎 0


import com.chenjian.cn.util.TreeNode;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution421 {
    int MAX_INT_BITS = 30;
    TrieNode root = new TrieNode();

    class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }

    //将元素加入字典树
    public void add(int n){
        TrieNode tmp = root;
        for (int i=MAX_INT_BITS; i>=0; i--){
            int bit = (n >> i) & 1; //从高位到低位判断该数是0还是1
            if (tmp.child[bit] == null){
                tmp.child[bit] = new TrieNode(); //实例化使之不为null,只有落在该数的位上才会被实例化
            }
            tmp = tmp.child[bit];

        }
    }

    public int search(int n){
        TrieNode tmp = root;
        int res = 0;
        for (int i=MAX_INT_BITS; i>=0; i--){
            int bit = (n >> i) & 1;
            if (tmp.child[bit^1] != null){ //每层的子节点不是0就是1，这操作是为了在bit为0时取到1，在bit为1时取到0
                //不为null时说明有过实例化，数组中有元素有这个位，可以为1
                int another = 1 << i;
                res += another;
                tmp = tmp.child[bit^1];
            }else {
                tmp = tmp.child[bit];
            }
        }
        return res;
    }

    public int findMaximumXOR(int[] nums) {
        int max = 0;
        for (int num: nums){
            add(num);

        }
        for (int num: nums){
            max = Math.max(max, search(num));
        }
        return max;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
