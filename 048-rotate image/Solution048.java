public class Solution048 {
    //Attempt1: 248ms
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        int depth = size / 2;
        for (int i = 0; i < depth; ++i) {
            for (int j = i; j < size - i - 1; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[size - 1 - j][i];
                matrix[size - 1 - j][i] = matrix[size - i - 1][size - j - 1];
                matrix[size - i - 1][size - j - 1] = matrix[j][size - i - 1];
                matrix[j][size - i - 1] = temp;
            }
        }
    }
}