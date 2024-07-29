package layOffDays.ModifiedBinarySearch;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/7/16 21:54
 */
public class SearchSortedInfiniteArray {

    public int search(ArrayReader reader, int target)  {
        int left = 0, right = 1;
        while (target > reader.get(right)) {
            if (target > reader.get(right)){
                left = right;
                right = right*2;
            }
        }

        while (left <= right) {
            int mid = left + (right-left)/2;
            if (reader.get(mid) == target) {
                return mid;
            }else if (reader.get(mid) > target) {
                right = mid-1;
            }else if (reader.get(mid) < target) {
                left = mid+1;
            }
        }
        return -1;

    }

    class ArrayReader {
        int[] arr;

        public ArrayReader(int[] arr){
            this.arr = arr;
        }
        int get(int index) {
            return this.arr[index];
        }
    }
}
