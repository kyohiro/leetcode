public class Solution062 {
    //Attempt1: 182ms
    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1)
            return 0;
        else if (m == 1 || n == 1)
            return 1;
            
        int array[][] = new int[m][n];
        for (int i = 0; i < m; ++i)
            array[i][n - 1] = 1;
        for (int i = 0; i < n; ++i)
            array[m - 1][i] = 1;
            
        for (int i = m - 2; i >= 0; --i) {
            for (int j = n - 2; j >= 0; --j) {
                array[i][j] = array[i + 1][j] + array[i][j + 1];
            }
        }
        
        return array[0][0];
    }
}