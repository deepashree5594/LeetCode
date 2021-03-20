class Solution {
    List<List<Integer>> graph;
    List<List<Integer>> result;
    int time;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        result = new ArrayList();
        graph = buildGraph(connections, n);
        System.out.println(graph);
        int[] discovery = new int[n];
        Arrays.fill(discovery, -1);
        int[] lowest = new int[n];
        // DFS
        dfs(discovery, lowest, 0, 0);
        return result;
    }
    private List<List<Integer>> buildGraph(List<List<Integer>> connections, int n)
    {
        graph = new ArrayList();
        for ( int i = 0; i < n; i++)
        {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> edge : connections)
        {
            int from = edge.get(0);
            int to = edge.get(1);
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        return graph;
    }
    private void dfs(int[] discovery, int[] lowest, int curr, int parent)
    {
        // base
        if (discovery[curr] != -1)
            return;
        // logic
        discovery[curr] = time;
        lowest[curr] = time;
        time++;
        for (int neighbor : graph.get(curr))
        {
            if (neighbor == parent)
                  continue;
            dfs(discovery, lowest, neighbor, curr);
            if (lowest[neighbor] > discovery[curr])
                result.add(Arrays.asList(neighbor, curr));
            if (lowest[curr] > lowest[neighbor])
            {
                lowest[curr] = lowest[neighbor];
            }                
        }
    }
}