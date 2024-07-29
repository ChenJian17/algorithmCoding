package layOffDays.ModifiedBinarySearch;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/7/10 23:04
 */
public class NextLetter {

    public static char nextGreatestLetter1(char[] letters, char target) {
        int start = 0, end = letters.length-1;
        while (start < end) {
            int mid = start+end >> 1;
            if (letters[mid] > target) {
                end = mid;
            }else {
                start = mid+1;
            }
        }
        return letters[end] > target ? letters[end] : letters[0];
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        if (letters[letters.length-1] >= target)
            return letters[0];

        int start = 0, end = letters.length-1;
        while (start < end) {
            int mid = start + (end-start)/2;
            if (letters[mid] < target) {
                start = mid+1;
            }else if (letters[mid] > target){
                end = mid;
            }else { // ==
                start = mid+1;
            }
        }
        return letters[start];

    }

    public static void main(String[] args) {

        char[] input = new char[]{'c','f','j'};
        System.out.println(nextGreatestLetter1(input,'c'));

    }
}
