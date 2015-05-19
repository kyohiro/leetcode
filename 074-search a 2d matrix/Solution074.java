public class Solution074 {
    //Attempt1: 328ms
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null)
            return false;

        int row = 0;
        while (row < matrix.length) {
            int first = matrix[row][0];
            if (first == target) return true;
            else if (first > target) break;
            else ++row;
        }
        if (row == 0) return false;
        else --row;

        int col = -1; 
        while (++col < matrix[row].length) {
            if (matrix[row][col] == target)
                return true;
        }

        return false;
    }
}