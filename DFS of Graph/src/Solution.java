import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();
        dfsHelper(0, visited, adj, res);
        return res;
    }

    private void dfsHelper(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> result) {
        visited[node] = true;
        result.add(node);
        for (int i : adj.get(node)) {
            if (!visited[i]) {
                dfsHelper(i, visited, adj, result);
            }
        }
    }
}