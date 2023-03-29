package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 深度优先搜索 广度优先搜索 动态规划 
// 👍 612 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution13 {
    public static int movingCount(int m, int n, int k) {
        boolean[][] flag = new boolean[m][n];
        return helper(0,0,m,n,k,flag);
    }
    public static int helper(int i, int j, int m, int n, int k, boolean[][] flag){
        if (i < 0 || i >= m || j < 0 || j >= n || sum(i)+sum(j) > k ){
            return 0;
        }
        if (!flag[i][j]) {
            flag[i][j] = true;
            return 1+helper(i-1,j,m,n,k,flag)
            + helper(i,j-1,m,n,k,flag)
            + helper(i+1,j,m,n,k,flag)
            + helper(i,j+1,m,n,k,flag);
        }
        return 0;

    }

    static int sum(int num){
        int res = 0;
        while (num != 0){
            int div = num%10;
            res += div;
            num = num/10;
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(movingCount(3,1,0));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
