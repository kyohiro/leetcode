public class Solution221 {
    //Attempt1: simple loop
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;

        int max = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                int rad = 1;    
                while (rad != 0 && i + rad <= matrix.length && j + rad <= matrix[i].length) {
                    for (int k = 0; k < rad; ++k) {
                        if (matrix[i + k][j + rad - 1] == '0' || matrix[i + rad - 1][j + k] == '0') {
                            rad = 0;
                            break;
                        }
                    }
                    if (rad != 0) {
                        max = Math.max(rad, max);
                        ++rad;
                    }
                }
            }
        }
        return max * max;
    }
}
