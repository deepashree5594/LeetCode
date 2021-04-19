class Solution {
    public int minPathSum(int[][] grid) {
        if ( grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        for ( int i = m-1; i>=0; i--){
            for ( int j = n-1; j>=0; j--){
                if (i != m-1 && j != n-1){
                    grid[i][j] = grid[i][j] + Math.min(grid[i+1][j], grid[i][j+1]);
                } else if (i == m-1 && j != n-1){
                    grid[i][j] = grid[i][j] + grid[i][j+1];
                } else if (i != m-1 && j == n-1){
                    grid[i][j] = grid[i][j] + grid[i+1][j];
                }
            }
        }
        return grid[0][0];
    }
}

//         9 9 9 9
// 1 3 1   9 1 0 0
// 1 5 1   9 0 0 0 
// 4 2 1   9 0 0 0