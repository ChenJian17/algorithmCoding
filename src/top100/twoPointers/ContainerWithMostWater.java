package top100.twoPointers;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/8/12 21:04
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        int res = -1;
        for (int i = 0; i<height.length-1; i++){
            for (int j = i+1; j<height.length; j++){
                int tmp = (j-i)*Math.min(height[i],height[j]);
                res = Math.max(res,tmp);
            }
        }
        return res;

    }

    public int maxArea1(int[] height) {

        int res = -1;
        int left = 0, right = height.length-1;
        while (left < right){
            int tmp = Math.min(height[left],height[right])*(right-left);
            res = Math.max(res,tmp);
            if (height[left] < height[right]){
                right --;
            }else {
                left ++;
            }

        }
        return res;

    }
}
