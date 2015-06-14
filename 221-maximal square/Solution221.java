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

    //Attempt2: DP
    public int maximalSquare2(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; ++i) {
            if (matrix[i][0] == '1') {
                max = 1;
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < matrix[0].length; ++i) {
            if (matrix[0][i] == '1') {
                max = 1;
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[i].length; ++j) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]) + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }

        return max * max;
    }
}
