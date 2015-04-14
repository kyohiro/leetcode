public class Solution200 {
    //Attempt1: 287ms
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int[][] mark = new int[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] != '0' && mark[i][j] == 0) {
                    markSpace(grid, mark, i, j);
                    ++count;
                }
            }
        } 
        return count;
    }

    private void markSpace(char[][] grid, int[][] mark, int i, int j) {
        if (i < 0 || i >= mark.length || j < 0 || j >= mark[0].length ||
            mark[i][j] == 1 || grid[i][j] == '0')
            return;
        mark[i][j] = 1;
        markSpace(grid, mark, i + 1, j);
        markSpace(grid, mark, i - 1, j);
        markSpace(grid, mark, i, j + 1);
        markSpace(grid, mark, i, j - 1);
    }
}