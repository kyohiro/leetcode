public class Solution036 {
    //Attempt1: 320ms
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            boolean[] bits = new boolean[9];
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.')
                    continue;
                if (bits[board[i][j] - '1'] == true)
                    return false;
                else
                    bits[board[i][j] - '1'] = true;
            }
        }
        
        for (int i = 0; i < 9; ++i) {
            boolean[] bits = new boolean[9];
            for (int j = 0; j < 9; ++j) {
                if (board[j][i] == '.')
                    continue;
                if (bits[board[j][i] - '1'] == true)
                    return false;
                else
                    bits[board[j][i] - '1'] = true;
            }
        }
        
        for (int i = 0; i <=6; i += 3) {
            for (int j = 0; j <=6; j += 3) {
                boolean[] bits = new boolean[9];
                for (int k = 0; k < 3; ++k) {
                    for (int l = 0; l < 3; ++l) {
                        if (board[i + k][j + l] == '.')
                            continue;
                        if (bits[board[i + k][j + l] - '1'] == true)
                            return false;
                        else
                            bits[board[i + k][j + l] - '1'] = true;
                    }
                }
            }
        }
        
        return true;
    }
    
}