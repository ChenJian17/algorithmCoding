package com.chenjian.cn.pointOffer;//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[
//i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。 
//
// 
//
// 示例: 
//
// 
//输入: [1,2,3,4,5]
//输出: [120,60,40,30,24] 
//
// 
//
// 提示： 
//
// 
// 所有元素乘积之和不会溢出 32 位整数 
// a.length <= 100000 
// 
// 👍 106 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution66 {
    public int[] constructArr(int[] a) {
        int[] result = new int[a.length];
        for (int i =0; i<a.length; i++){
            int left =1, right =1;
            for (int j =0; j<i; j++)
                left *= a[j];
            for (int k = i+1; k< a.length; k++)
                right *= a[k];

            result[i] = left*right;
        }
        return result;

    }

    public int[] constructArr2(int[] a){
        if (a.length == 0 || a == null)
            return a;
        int n = a.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i<n; i++){
            res[i] = res[i-1]*a[i-1];
        }
        int right = 1;
        for (int i = n-1; i>=0; i--){
            res[i] = res[i] * right;
            right = right*a[i];
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
