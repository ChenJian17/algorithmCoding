package top100;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/6/9 20:55
 */
public class SortColors {

    public void sortColors(int[] nums){
        int zero = 0, i = 0, last = nums.length-1;
        while (i < last){
            if (nums[i] == 0){
                swap(nums,zero,i);
                zero++;
                i++;
            }else if (nums[i] == 1){
                i++;
            }else {
                swap(nums,i,last);
                last--;
//                i++;
            }
        }
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public void sortColors1(int[] nums) {

        int len = nums.length;
        int i = 0;

        for(int col = 0; col < 3; col++){
            i = fun(i, col, nums);
            if (i >= len-1)
                break;
        }

    }

    public int fun(int i, int num, int[] nums){
        while(nums[i] == num){
            i++;
            if (i >= nums.length-1)
                return i;
        }

        int j = i+1;
        while(j < nums.length){
            if(nums[j] == num){
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                i++;
            }
            j++;

        }

         return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        SortColors ob = new SortColors();
        ob.sortColors(nums);
    }
}
