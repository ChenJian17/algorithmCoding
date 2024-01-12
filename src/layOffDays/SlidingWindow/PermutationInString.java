package layOffDays.SlidingWindow;

import java.util.Arrays;

/**
 * @BelongsProject: algorithmCoding
 * @BelongsPackage: layOffDays.slidingWindow
 * @Author: Joker
 * @CreateTime: 2023-03-04 22:17
 * @Description:
 */
public class PermutationInString {
//    public boolean checkInclusion(String s1, String s2) {
//        int point = 0;
//        int[] boo = new int[s1.length()];
//
//        while (point < s2.length()) {
//
//
//            char c = s2.charAt(point);
//            if (s1.contains(String.valueOf(c))) {
//                int tmp = point;
//                while (s1.contains(String.valueOf(s2.charAt(tmp)))) {
//                    tmp ++;
//                }
//            }
//        }
//
//    }



    static boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if (l1 > l2) {
            return false;
        }
        int[] arr1 = new int[26], arr2 = new int[26];
        for (int i =0; i < l1; i++) {
            arr1[s1.charAt(i) - 'a'] ++;
            arr2[s2.charAt(i) - 'a'] ++;
        }
        int left = 0, right = l1-1;
        while (right < l2) {
            if (Arrays.equals(arr1, arr2)) {
                return true;
            }
            arr2[s2.charAt(left)-'a'] --;
            left++;
            right++;
            if (right != l2) {
                arr2[s2.charAt(right)-'a']++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        checkInclusion(s1,s2);
    }
}
