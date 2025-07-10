package top150;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/6/29 09:32
 */
public class RemoveElementII {
    public int removeDuplicates(int[] nums) {
        int first = 0, second = 0;
        int len = nums.length;
        int count = 0;
        while(second < len){
            if(nums[first] == nums[second]){
                second ++;
                count ++;
            }else{
                if(count >= 2){
                    nums[first+2] = nums[second];
                    nums[first+1] = nums[first];
                    first += 2;
                }else {
                    nums[first+1] = nums[second];
                    first++;
                }
                count = 1;
                second++;

            }

        }

        if(count >= 2){
            nums[first+1] = nums[first];
            first ++;
        }
        return first+1;

    }
}
