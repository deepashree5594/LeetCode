class Solution {
    public void wallsAndGates(int[][] rooms) {
        if ( rooms == null || rooms[0].length == 0)
            return;
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList();
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {-1,0}, {1,0}};
        for ( int i = 0; i < m; i++)
        {
            for ( int j = 0; j < n; j++)
            {
                if (rooms[i][j] == 0)
                    q.offer(new int[] {i,j});
                    
            }
        }
        while (!q.isEmpty())
        {
            int[] cur = q.poll();
            for ( int[] dir : dirs)
            {
                int r = cur[0] + dir[0];
                int c = cur[1] + dir[1];
                if ( r >= m || c >= n || r < 0 || c < 0 ||  rooms[r][c] != Integer.MAX_VALUE) 
                    continue;
                rooms[r][c] = rooms[cur[0]][cur[1]] + 1;
                q.offer(new int[]{r,c});
            }
        }
    }
}
