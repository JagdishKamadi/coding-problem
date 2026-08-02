class Solution {
    public boolean exist(char[][] board, String word) {
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == wordArray[0] && exist(board, i, j, wordArray, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int i, int j, char[] wordArray, int index) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != wordArray[index] || board[i][j] == '*') {
            return false;
        }
        if (wordArray.length - 1 == index) {
            return true;
        }
        char ch = board[i][j];
        board[i][j] = '*';
        boolean result = exist(board, i + 1, j, wordArray, index + 1)
                || exist(board, i - 1, j, wordArray, index + 1)
                || exist(board, i, j + 1, wordArray, index + 1)
                || exist(board, i, j - 1, wordArray, index + 1);
        board[i][j] = ch;

        return result;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(new Solution().exist(board, word));
    }
}