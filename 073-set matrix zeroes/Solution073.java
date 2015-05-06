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

    //Attempt2: 386ms - constant space
    public void setZeroes2(int[][] matrix) {
        if (matrix == null)
            return;

        int rows = matrix.length, cols = matrix[0].length;
        boolean firstRow = false, firstCol = false;
        for (int i = 0; i < rows; ++i) {
            if (matrix[i][0] == 0) {
                firstCol = true;
                break;
            }
        }
        for (int j = 0; j < cols; ++j) {
            if (matrix[0][j] == 0) {
                firstRow = true;
                break;
            }
        }

        for (int i = 1; i < rows; ++i) {
            for (int j = 1; j < cols; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < rows; ++i) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < cols; ++j)
                   matrix[i][j] = 0;
            }
        }

        for (int j = 1; j < cols; ++j) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < rows; ++i)
                    matrix[i][j] = 0;
            }
        }

        if (firstRow) {
            for (int i = 0; i < cols; ++i)
                matrix[0][i] = 0;
        }

        if (firstCol) {
            for (int i = 0; i < rows; ++i)
                matrix[i][0] = 0;
        }

    }
}