public class Solution064 {
    //Attempt1: 364ms
    public int minPathSum(int[][] grid) {
        if (grid == null)
            return 0;
        int rows = grid.length, cols = grid[0].length;
        int array[][] = new int[rows][cols];

        for (int i = rows - 1; i >= 0; --i) {
            for (int j = cols - 1; j >= 0; --j) {
                array[i][j] = grid[i][j];
                if (j + 1 < cols && i + 1 < rows)
                    array[i][j] += Math.min(array[i][j + 1], array[i + 1][j]);
                else if (j + 1 < cols)
                    array[i][j] += array[i][j + 1];
                else if (i + 1 < rows)
                    array[i][j] += array[i + 1][j];
            }
        }

        return array[0][0];
    }
}