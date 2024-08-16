package top100.twoPointers;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/8/15 23:13
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int res = 0;
        for (int i = 1; i<height.length-1; i++){
            int max_left = 0;
            for (int j =1; j<i; j++){
                max_left = Math.max(height[j], max_left);
            }

            int max_right = 0;
            for (int j=i+1; j<height.length-1; j++){
                max_right = Math.max(height[j],max_right);
            }

            int low = Math.min(max_right,max_left);

            if (low > height[i]){
                res += low-height[i];
            }
        }
        return res;

    }

    public int trap1(int[] height) {
        int left = 0, right = height.length-1;
        int leftMax = height[left], rightMax = height[right];

        int res = 0;
        while (left <= right) {
            left++;
            right--;
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            if (leftMax < rightMax){
                //rightMax 大于 left(包括left)左边所有元素
                res += leftMax-height[left];
                left ++;
            }else {
                res += rightMax-height[right];
                right--;
            }
        }
        return res;

    }

}
