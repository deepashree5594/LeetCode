// Minimum spanning tree - Kruskal's algo
class Solution {
    int[] parent;
    int n;
    public void union(int x, int y)
    {
        parent[x] = y;
        n--;
    }
    public int find(int x)
    {
        if (parent[x] == x)
        {
            return parent[x];
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }
    public int minimumCost(int N, int[][] connections) {
        parent = new int[N+1];
        n = N;
        for( int i = 0; i <= N; i++)
        {
            parent[i] = i;
        }
        Arrays.sort(connections, (a,b) ->a[2] - b[2]);
        int res = 0;
        for (int[] connection: connections)
        {
            int x = connection[0];
            int y = connection[1];
            if ( find(x) != find(y) )
            {
                res = res + connection[2];
                union(find(x),find(y));
            }
        }
   return n == 1? res : -1;
    }
}
