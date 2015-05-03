public class Solution063 {
    //Attempt1: 277ms
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null)
            return 0;

        int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
        int array[][] = new int[rows][cols];
        array[rows - 1][cols - 1] = 1;
        for (int i = rows - 1; i >= 0; --i) {
            for (int j = cols - 1; j >= 0; --j) {
                if (obstacleGrid[i][j] == 1)
                    array[i][j] = 0;
                else {
                    if (j + 1 < cols)
                        array[i][j] += array[i][j + 1];
                    if (i + 1 < rows)
                        array[i][j] += array[i + 1][j];
                }
            }
        }

        return array[0][0];
    }
}