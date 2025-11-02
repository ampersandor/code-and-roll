class Solution {
    private static final int N = 9;
    private static final int O = '1';
    public boolean isValidSudoku(char[][] board) {
        // Check Rows
        if (!isValidRow(board)) return false;
        
        // Check Columns
        if (!isValidCol(board)) return false;
        
        return isValidBox(board);

    }

    private boolean isValidRow(char[][] board) {
        for (int i = 0; i < N; i ++){
            boolean[] digits = new boolean[9];
            for (int j = 0; j < N; j++) {
                if (Character.isDigit(board[i][j])) {
                    if (digits[(int) board[i][j] - O]) return false;
                    digits[(int) board[i][j] - O] = true;
                }
            }
        }
        return true;
    }

    private boolean isValidCol(char[][] board) {
        for (int j = 0; j < N; j++){
            boolean[] digits = new boolean[N];
            for (int i = 0; i < N; i++){
                if (!Character.isDigit(board[i][j])) continue;
                if (digits[(int) board[i][j] - O]) return false;
                digits[(int) board[i][j] - O] = true;
            }
        }
        return true;
    }

    private boolean isValidBox(char[][] board) {
        for (int s = 0; s < N; s++) {
            boolean[] digits = new boolean[N];
            int x = (s / 3) * 3;
            int y = (s % 3) * 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int nx = x + i;
                    int ny = y + j;
                    char ch = board[nx][ny];
                    if (!Character.isDigit(ch)) continue;
                    if (digits[ch - O]) return false;
                    digits[ch - O] = true;
                }
            }
        }
        return true;
    }
}