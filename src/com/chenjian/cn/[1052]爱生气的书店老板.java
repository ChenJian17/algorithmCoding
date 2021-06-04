package com.chenjian.cn;//今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分
//钟结束后离开。 
//
// 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一
//分钟的顾客就会不满意，不生气则他们是满意的。 
//
// 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。 
//
// 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。 
// 
//
// 示例： 
//
// 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
//输出：16
//解释：
//书店老板在最后 3 分钟保持冷静。
//感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
// 
//
// 
//
// 提示： 
//
// 
// 1 <= X <= customers.length == grumpy.length <= 20000 
// 0 <= customers[i] <= 1000 
// 0 <= grumpy[i] <= 1 
// 
// Related Topics 数组 Sliding Window 
// 👍 151 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum = 0;
        for(int i =0; i< X; i++){
            if(grumpy[i] == 1){
                sum += customers[i];
            }

        }
        int total = sum;
        int flag = 0;
        for(int i =1; i+X <= customers.length; i++){
            int first = grumpy[i-1] == 1 ? customers[i-1] : 0;
            System.out.println(grumpy[i-1]);
            int last = grumpy[X+i-1] == 1 ? customers[X+i-1] : 0;
            int temp = sum - first + last;
            sum = temp;
            if (total < temp){
                total = temp;
                flag = i;
            }

        }
        System.out.println("sum: "+sum);
        sum = 0;
        for(int j = flag; j < flag+X; j++){
            sum += customers[j];
        }

        int result = 0;
        int i = 0;
        while(i < customers.length){
            if (i == flag){
                result += sum;
                i = i + X;
            }else if (i != flag && grumpy[i] == 0) {
                result += customers[i];
                i++;
            }else{
                i ++;
            }
        }
        System.out.println(result);

        return result;
    }

    public static int maxSatisfied1(int[] customers, int[] grumpy, int X) {
        int ans = 0;
        for(int i =0; i < customers.length; i++){
            if(grumpy[i] == 0){
                ans += customers[i];
                customers[i] = 0;
            }
        }
        int max = 0, cur = 0;

        for(int i =0, j =0; i < customers.length; i ++){
            cur += customers[i];
            if(i - j + 1 > X){
                cur -= customers[j++];
            }
            max = Math.max(max, cur);
        }

        return ans+max;

    }

    public static void main(String[] args) {
        // write your code here
        int[] customers = new int[]{9,10,4,5};
        int[] grumpy = new int[]{1,0,1,1};
        int X = 1;
        maxSatisfied(customers, grumpy, X);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
