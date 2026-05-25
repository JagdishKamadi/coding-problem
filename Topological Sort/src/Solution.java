import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int v = 0; v < V; v++) {
            if (!visited[v]) {
                dfs(v, adj, visited, stack);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }

        return ans;
    }

    private void dfs(int node,
                     ArrayList<ArrayList<Integer>> adj,
                     boolean[] visited,
                     Stack<Integer> stack) {

        visited[node] = true;

        for (int next : adj.get(node)) {
            if (!visited[next]) {
                dfs(next, adj, visited, stack);
            }
        }

        stack.push(node);
    }
}