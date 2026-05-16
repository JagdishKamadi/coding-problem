import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int vertices = adj.size();

        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[vertices];

        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);

            for (int neighbor : adj.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        return result;
    }
}