import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, pathVisited, stack)) {
                    return new int[0];
                }
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        while (!stack.isEmpty()) {
            result[index++] = stack.pop();
        }

        return result;
    }

    private boolean dfs(
            int node,
            List<List<Integer>> adj,
            boolean[] visited,
            boolean[] pathVisited,
            Stack<Integer> stack
    ) {

        visited[node] = true;
        pathVisited[node] = true;

        for (int next : adj.get(node)) {
            if (!visited[next]) {
                if (dfs(next, adj, visited, pathVisited, stack)) {
                    return true;
                }
            } else if (pathVisited[next]) {
                return true;
            }
        }

        pathVisited[node] = false;
        stack.push(node);
        return false;
    }
}