public class Solution054 {
    //Attempt1: 304ms
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0)
            return result;

        int rows = matrix.length, cols = matrix[0].length;
        int loop = 0, loops = Math.min(rows, cols) / 2;

        while (loop < loops) {
            int i = loop, j = loop;
            for (; j < cols - loop - 1; ++j)
                result.add(matrix[i][j]);
            for (; i < rows - loop - 1; ++i)
                result.add(matrix[i][j]);
            for (; j > loop; --j)
                result.add(matrix[i][j]);
            for (; i > loop; --i)
                result.add(matrix[i][j]);

            ++loop;
        }
        
        if ((rows & 1) == 1 && (cols & 1) == 1 && rows == cols)
            result.add(matrix[loops][loops]);
        else if ((rows & 1) == 1 && rows < cols)
            for (int j = loops; j < cols - loops; ++j)
                result.add(matrix[loops][j]);
        else if ((cols & 1) == 1 && cols < rows)
            for (int i = loops; i < rows - loops; ++i)
                result.add(matrix[i][loops]);
        return result;
    }
}