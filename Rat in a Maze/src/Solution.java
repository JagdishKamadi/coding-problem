import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> result = new ArrayList<>();
        if (maze[0][0] == 0) {
            return result;
        }
        boolean[][] visited = new boolean[maze.length][maze.length];
        findPaths(maze, 0, 0, "", result, visited);
        Collections.sort(result);
        return result;
    }

    private void findPaths(int[][] maze, int r, int c, String path, ArrayList<String> result, boolean[][] visited) {
        int n = maze.length;
        if (r < 0 || c < 0 || r >= n || c >= n || maze[r][c] == 0 || visited[r][c]) {
            return;
        }

        if (r == n - 1 && c == n - 1) {
            result.add(path);
            return;
        }
        visited[r][c] = true;
        findPaths(maze, r + 1, c, path + "D", result, visited);
        findPaths(maze, r - 1, c, path + "U", result, visited);
        findPaths(maze, r, c - 1, path + "L", result, visited);
        findPaths(maze, r, c + 1, path + "R", result, visited);
        visited[r][c] = false;
    }

    public static void main(String[] args) {
        int[][] maze = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println(new Solution().ratInMaze(maze));
    }
}