package top150;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/6/26 15:56
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        int len = nums.length;
        if(len == 0){
            return 0;
        }
        if(len == 1){
            return val == nums[0] ? 0 : 1;
        }

        int head = 0, tail = len-1;
        int count = 0;
        while(head != tail){
            if(nums[head] == val){
                swap(head,tail,nums);
                count ++;
                tail --;
            }else{
                head ++;
            }
        }
        if(nums[head] == val){
            return len-count-1;
        }

        return len-count;

    }

    public void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,2,3,0,4,2};
        RemoveElement ob = new RemoveElement();
        ob.removeElement(arr,2);
    }
}
