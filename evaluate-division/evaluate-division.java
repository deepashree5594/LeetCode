class Solution {
    class Node {
        String key;
        double val;
        Node(String k, double v){
            this.key = k;
            this.val = v;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        if (equations == null || equations.size() == 0 || queries == null || queries.size() == 0)
            return new double[]{};
        
        HashMap<String, List<Node>> graph = buildGraph(equations, values);
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++){
            result[i] = dfs(graph, queries.get(i).get(0), queries.get(i).get(1), new HashSet());
        }
        return result;
    }
    private double dfs(HashMap<String, List<Node>> graph, String src, String dest, HashSet<String> visited){
        //base
        if (!graph.containsKey(src) || !graph.containsKey(dest) ){
            return -1.0;
        }
        if (src.equals(dest)){
            return 1.0;
        }
        //logic
        visited.add(src);
        List<Node> neighbors = graph.get(src);
        for (Node neighbor : neighbors ) {
            if (!visited.contains(neighbor.key)) {
                double ans = dfs(graph, neighbor.key, dest, visited);
                if (ans != -1.0){
                    return ans * neighbor.val;
                }
             } 
        }
       return -1.0;
     }
    private HashMap<String, List<Node>> buildGraph(List<List<String>> equations, double[] values){
        HashMap<String, List<Node>> graph = new HashMap();
        for(int i = 0; i < values.length; i++){
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            if (!graph.containsKey(src)){
                graph.put(src, new ArrayList());
            }
            graph.get(src).add(new Node(dest, values[i]));
            if (!graph.containsKey(dest)){
                graph.put(dest, new ArrayList());
            }
            graph.get(dest).add(new Node(src, 1/values[i]));
        }
        return graph;
    }
}