package top100.binarySearch;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/4/13 16:26
 */
public class Median {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] merge = new int[nums1.length+nums2.length];
        int left = 0, right = 0;
        for (int i = 0; i<merge.length; i++){
            if (left == nums1.length){
                while (right != nums2.length){
                    merge[i++] = nums2[right++];
                }
                break;
            }
            if (right == nums2.length){
                while (left != nums1.length){
                    merge[i++] = nums1[left++];
                }
                break;
            }
            if (nums1[left] < nums2[right]){
                merge[i] = nums1[left];
                left++;
            }else {
                merge[i] = nums2[right];
                right ++;
            }
        }

        if (merge.length %2 ==0){
            return (merge[merge.length/2 -1]+merge[merge.length/2])/2.0;
        }else {
            return merge[merge.length/2];
        }


    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1,2};
        int[] num2 = new int[]{3,4};
        Median median = new Median();
        median.findMedianSortedArrays(num1, num2);
    }
}
