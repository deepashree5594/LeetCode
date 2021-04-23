class DSU{
    int[] parent;
    int[] rank;
    DSU(int size){
        parent = new int[size];
        rank = new int[size];
        Arrays.fill(rank, 1);
        for (int i = 0; i < size; i++){
            parent[i] = i;
        }
    }
    public void union(int x, int y){
        int parentX = parent[x];
        int parentY = parent[y];
        if (parentX == parentY)
            return;
        else if (rank[parentX] < rank[parentY]){
             parent[parentX] = parentY;
        } else if (rank[parentX] > rank[parentY]){
            parent[parentY] = parentX;
        } else {
            rank[parentX]++;
            parent[parentY] = parentX;
        }
       
    }
    public int find(int x){
        if (x != parent[x]){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
class Solution {
    public boolean isBipartite(int[][] graph) {
        if ( graph == null || graph.length == 0)
            return false;
        int n = graph.length;
        DSU dsu = new DSU(n);
        for (int u = 0; u < n; u++){
            int[] neighbors = graph[u];
            for (int v: neighbors){
                if (dsu.find(u) == dsu.find(v)){
                    return false;
                }
                dsu.union(v, neighbors[0]);
            }
        }
        return true;
    }
}