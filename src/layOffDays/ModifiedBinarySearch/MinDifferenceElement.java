package layOffDays.ModifiedBinarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/7/17 23:25
 */
public class MinDifferenceElement {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int size = arr.length;
        int anr = size-k;
        int left = 0, right = size-1;
        while (anr > 0) {
            if (Math.abs(arr[left]-x) > Math.abs(arr[right]-x)) {
                left ++;
            }else {
                right--;
            }
            anr --;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = left; i<= right; i++) {
            res.add(arr[i]);
        }
        return res;

    }

    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        int low = 0, high = arr.length-k; //左端点极限能取到 arr.length-k
        while (low < high) {
            int mid = low+(high-low)/2;
            System.out.println("Math.ab: "+Math.abs(arr[mid] - x));
            System.out.println("Math.ab: "+Math.abs(arr[mid+k]-x));

            System.out.println("negative: " + (arr[mid] - x));
            System.out.println("negative: " + (arr[mid+k]-x));
//            if (Math.abs(arr[mid] - x) > Math.abs(arr[mid+k]-x)) {
//                low = mid+1;
//            }else if (Math.abs(arr[mid] - x) < Math.abs(arr[mid+k]-x)) {
//                high = mid;
//            }else if (Math.abs(arr[mid] - x) == Math.abs(arr[mid+k]-x)) {
//                high = mid;
//            }
            if (Math.abs(arr[mid] - x) > Math.abs(arr[mid+k]-x)) {
                low = mid+1;
            }else if (Math.abs(arr[mid] - x) < Math.abs(arr[mid+k]-x)) {
                high = mid;
            }else if (Math.abs(arr[mid] - x) == Math.abs(arr[mid+k]-x)) {
                high = mid;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = low; i<low+k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,2,2,2,2,3,3};
        MinDifferenceElement element = new MinDifferenceElement();
        element.findClosestElements1(nums,3,3);
    }
}
