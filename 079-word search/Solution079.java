public class Solution079 {
    //Attempt1: 380ms
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (exist(board, word, i, j, 0))
                    return true;
            }
        }

        return false;
    }

    private boolean exist(char[][] board, String word, int row, int col, int pos) {
        if (board[row][col] != word.charAt(pos) || board[row][col] == ' ')
            return false;
        else if (pos == word.length() - 1)
            return true;

        char c = board[row][col];
        board[row][col] = ' ';
        if ((row > 0 && exist(board, word, row - 1, col, pos + 1)) ||
            (row < board.length - 1 && exist(board, word, row + 1, col, pos + 1)) ||
            (col > 0 && exist(board, word, row, col - 1, pos + 1)) ||
            (col < board[0].length - 1 && exist(board, word, row, col + 1, pos + 1))) {
            board[row][col] = c;
            return true;
        }

        board[row][col] = c;
        return false;
    }
}