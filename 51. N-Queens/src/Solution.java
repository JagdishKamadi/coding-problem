import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        placeQueens(board, 0, n, result);
        return result;
    }

    private void placeQueens(char[][] board, int row, int n, List<List<String>> result) {
        if (row == n) {
            result.add(construct(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafeToPlaceQueen(board, row, col, n)) {
                board[row][col] = 'Q';
                placeQueens(board, row + 1, n, result);
                board[row][col] = '.';
            }
        }

    }

    private List<String> construct(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            result.add(new String(row));
        }
        return result;
    }

    private boolean isSafeToPlaceQueen(char[][] board, int row, int column, int n) {
        // travel horizontally & vertically
        for (int i = 0; i < n; i++) {
            if (board[row][i] == 'Q' || board[i][column] == 'Q') {
                return false;
            }
        }
        // travel left diagonally
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // travel right diagonally
        for (int i = row, j = column; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Solution().solveNQueens(4).forEach(System.out::println);
    }
}