import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            int row = poll.row;
            int col = poll.col;
            int time = poll.time;
            ans = Math.max(ans, time);

            // travel top
            if (row - 1 >= 0 && !visited[row - 1][col] && grid[row - 1][col] == 1) {
                queue.offer(new Pair(row - 1, col, time + 1));
                visited[row - 1][col] = true;
            }
            // travel bottom
            if (row + 1 < n && !visited[row + 1][col] && grid[row + 1][col] == 1) {
                queue.offer(new Pair(row + 1, col, time + 1));
                visited[row + 1][col] = true;
            }
            // travel left
            if (col - 1 >= 0 && !visited[row][col - 1] && grid[row][col - 1] == 1) {
                queue.offer(new Pair(row, col - 1, time + 1));
                visited[row][col - 1] = true;
            }
            // travel right
            if (col + 1 < m && !visited[row][col + 1] && grid[row][col + 1] == 1) {
                queue.offer(new Pair(row, col + 1, time + 1));
                visited[row][col + 1] = true;
            }
        }

        // check for fresh oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    return -1;
                }
            }
        }
        return ans;
    }

    private static class Pair {
        private int row;
        private int col;
        private int time;

        public Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }
    }
}