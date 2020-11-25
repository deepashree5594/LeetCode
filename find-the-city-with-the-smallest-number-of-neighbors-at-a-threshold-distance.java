//Floyd- Warshall algo
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int result = 0;
        int smallest = n;
        int[][] dist = new int[n][n];
        for (int[] row: dist)
        {
            Arrays.fill(row, 10001);
        }
        for (int[] edge: edges)
        {
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }
        for (int i = 0; i < n; ++i)
        {
            dist[i][i] = 0;
        }
        for (int k = 0; k < n; k++)
        {
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        
        for (int i = 0; i < n; i++)
        {
            int count = 0;
            for (int j = 0; j < n; j++)
            {
                if (dist[i][j] <= distanceThreshold)
                {
                    count++;
                }
            }
            if (count <= smallest)
            {
                smallest = count;
                result = i;
            }
        }
        return result;
    }
}
