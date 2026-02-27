class Solution {
    public boolean exist(char[][] board, String word) {
        char[] wordCharArray = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) || exists(board, i, j, wordCharArray, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exists(char[][] board, int i, int j, char[] word, int index) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[index] || board[i][j] == '*') {
            return false;
        }
        if (index == word.length - 1) {
            return true;
        }
        char c = board[i][j];
        board[i][j] = '*';
        boolean result =
                exists(board, i + 1, j, word, index + 1) ||
                        exists(board, i - 1, j, word, index + 1) ||
                        exists(board, i, j + 1, word, index + 1) ||
                        exists(board, i, j - 1, word, index + 1);
        board[i][j] = c;
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