public class Solution059 {
    //Attempt1: 195ms
    public int[][] generateMatrix(int n) {
        int result[][] = new int[n][n];
        int loops = n / 2, loop = 0;

        int num = 1;
        while (loop < loops) {
            int i = loop, j = loop;
            for (; j < n - loop - 1; ++j)
                result[i][j] = num++;
            for (; i < n - loop - 1; ++i)
                result[i][j] = num++;
            for (; j > loop; --j)
                result[i][j] = num++;
            for (; i > loop; --i)
                result[i][j] = num++;

            ++loop;
        }

        if ((n & 1) == 1)
            result[loop][loop] = num;

        return result;
    }
}