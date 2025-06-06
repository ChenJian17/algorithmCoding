package top100.binarySearch;

import java.util.Stack;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/4/21 21:15
 */
public class LargestRectangle {

    public int largestRectangleArea(int[] heights) {

        int len = heights.length;
        if (len == 0)
            return 0;
        if (len == 1)
            return heights[0];

        Stack<Integer> stack = new Stack<>();
        int area = 0;
        for (int i = 0; i<heights.length; i++){
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                int height = heights[stack.pop()];
                // case 1: 相邻两个条柱高度相等
                while (!stack.isEmpty() && height == heights[stack.peek()]){
                    stack.pop();
                }


                int width;
                // case 2:
                if (stack.isEmpty()){
                    width = i;
                }else {
                    width = i - stack.peek() -1;
                }
                area = Math.max(area, width*height);
            }
            stack.push(i);
        }

        while (!stack.isEmpty() ){
            int height = heights[stack.pop()];
            // case 1: 相邻两个条柱高度相等
            while (!stack.isEmpty() && height == heights[stack.peek()]){
                stack.pop();
            }


            int width;
            // case 2:
            if (stack.isEmpty()){
                width = len;
            }else {
                width = len - stack.peek() -1;
            }
            area = Math.max(area, width*height);
        }

        return area;

    }
}
