//https://www.youtube.com/watch?v=c1ZxUOHlulo&ab_channel=MichaelMuinos
// DFS
// store the recursive call directions in the hashset and return the size of set
// X - start
// O - index out of boound or water
// U - up
// D - down
// L - left
// R - right
class Solution {
    public int numDistinctIslands(int[][] grid) {
        if ( grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        HashSet<String> set = new HashSet();
        for ( int i = 0; i < m; i++)
        {
            for ( int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1)
                {
                    String path = computePath(grid, i, j, m, n, "X");
                    set.add(path);
                }
            }
        }
        return set.size();
    }
    private String computePath(int[][] grid, int r, int c, int m, int n, String direction)
    {
        //base
        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == 0)
            return "O";
        
        //logic
        grid[r][c] = 0;
        String left = computePath(grid, r, c-1, m, n, "L");
        String right = computePath(grid, r, c+1, m, n, "R");
        String up = computePath(grid, r-1, c, m, n, "U");
        String down = computePath(grid, r+1, c, m, n, "D");
        return direction+left+right+up+down;
        
    }
}
