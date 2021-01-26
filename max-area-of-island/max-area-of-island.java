class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
       int  m = grid.length;
       int  n = grid[0].length;
       int maxArea = 0;
        for ( int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == 1)
                {
                   int currentArea = dfs(grid, i, j, m,n);
                   maxArea = Math.max(maxArea, currentArea);
                }
            }
        }
        return maxArea;
    }
    private int dfs(int[][] grid, int r, int c, int m, int n)
    {
        //base
        if (r >= m || c>= n || r < 0 || c < 0 || grid[r][c] == 0)
            return 0;
        //logic
        grid[r][c] = 0;
        int left = dfs(grid, r, c-1, m, n);
        int right = dfs(grid, r, c+1, m, n);
        int up = dfs(grid, r-1, c, m, n);
        int down = dfs(grid, r+1, c, m, n);
        return 1+left+right+up+down;
            
    }
}
