public class Solution073 {
    //Attempt1: 392ms - O(M+N) extra space
    public void setZeroes(int[][] matrix) {
        if (matrix == null) 
            return;
        int rows = matrix.length, cols = matrix[0].length;
        int arrayRows[] = new int[rows];
        int arrayCols[] = new int[cols];

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (matrix[i][j] == 0) {
                    arrayRows[i] = 1;
                    arrayCols[j] = 1;
                }
            }
        }

        for (int i = 0; i < rows; ++i)
            for (int j = 0; j < cols; ++j)
                if (arrayRows[i] == 1 || arrayCols[j] == 1)
                    matrix[i][j] = 0;
    }
}