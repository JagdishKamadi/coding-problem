class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {
        boolean[][] graph = new boolean[v][v];
        for (int[] edge : edges) {
            int u = edge[0];
            int w = edge[1];
            graph[u][w] = true;
            graph[w][u] = true; // undirected graph
        }
        int[] color = new int[v];
        return solve(0, graph, color, m, v);
    }

    public boolean solve(int node, boolean[][] graph, int[] color, int m, int v) {
        if (node == v) {
            return true;
        }
        for (int c = 1; c <= m; c++) {
            if (canPlaceColor(node, graph, color, c, v)) {
                color[node] = c;
                if (solve(node + 1, graph, color, m, v))
                    return true;

                // Backtrack
                color[node] = 0;
            }
        }
        return false;
    }

    private boolean canPlaceColor(int node, boolean[][] graph, int[] color, int c, int v) {
        for (int i = 0; i < v; i++) {
            if (graph[node][i] && color[i] == c) {
                return false;
            }
        }
        return true;
    }
}