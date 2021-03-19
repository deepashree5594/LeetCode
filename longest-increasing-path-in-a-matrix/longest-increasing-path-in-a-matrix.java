class Solution {
    public int longestIncreasingPath(int[][] matrix) {
       if (matrix == null || matrix.length == 0)
          return 0;
        int result = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for ( int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (dp[i][j] == 0)
                {
                    dp[i][j]  = dfs(matrix, i, j, m, n, dp, Integer.MIN_VALUE);
                    result = Math.max(result,  dp[i][j]);
                }
            }
        }
       return result;
    }
    private int dfs(int[][] matrix, int i, int j, int m, int n, int[][] dp, int prevVal)
    {
        //base case
        if (i < 0 || j < 0 || i >= m || j >= n || matrix[i][j] <= prevVal)
            return 0;
        if (dp[i][j] != 0)
            return dp[i][j];
        
        //logic
        int left = dfs(matrix, i, j-1, m, n, dp, matrix[i][j]);
        int right = dfs(matrix, i, j+1, m, n, dp, matrix[i][j]);
        int up = dfs(matrix, i-1, j, m, n, dp, matrix[i][j]);
        int down = dfs(matrix, i+1, j, m, n, dp ,matrix[i][j]);
        dp[i][j] = 1 + Math.max(up, Math.max(down, Math.max(left, right)));
        return dp[i][j];
    }
}


