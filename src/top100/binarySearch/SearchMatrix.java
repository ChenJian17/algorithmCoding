package top100.binarySearch;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/3/31 21:47
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m*n-1;
        while (left < right){
            int mid = (left+right)/2;
            if (matrix[mid/n][mid%n] <= target){
                left = mid;
            }else {
                right = mid-1;
            }
        }
        return matrix[left/n][left%n] == target;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        SearchMatrix searchMatrix = new SearchMatrix();
        searchMatrix.searchMatrix(matrix,3);

    }
}
