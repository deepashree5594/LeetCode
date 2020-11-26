class Solution {
    public int countServers(int[][] grid) {
        if ( grid.length == 0 || grid == null)
            return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[] rows = new int[m];
        int[] cols = new int[n];
        
        int result = 0;
        
        for ( int i = 0; i < m; i++)
        {
            for ( int j = 0; j < n; j++)
            {
                if (grid[i][j] == 1)
                {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        for ( int i = 0; i < m; i++)
        {
            for ( int j = 0; j < n; j++)
            {
                if (grid[i][j] == 1 && (rows[i] > 1 || cols[j] >1 ))
                    result++;
            }
        }
     return result;
    }
}
