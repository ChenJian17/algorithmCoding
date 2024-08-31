package top100.array;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/8/29 21:38
 */
public class ProductArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {

        int[] res = new int[nums.length];
        for (int i = 0; i<nums.length; i++){
            if (i == 0){
                res[i] = 1;
            }else {
                res[i] = res[i-1]*nums[i-1];
            }
        }

        int tmp = 1;
        for (int i = nums.length-1; i>=0; i--){
            if (i == nums.length-1){
                res[i] = res[i]*tmp;
            }else {
                tmp *= nums[i+1];
                res[i] *= tmp;
            }
        }

        return res;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        System.out.println(productExceptSelf(arr));;
    }
}
