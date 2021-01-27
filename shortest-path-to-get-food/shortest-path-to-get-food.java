// class Solution {
//     public int getFood(char[][] grid) {
//         // if ( grid == null || grid.length == 0)
//         //     return -1;
//         int[][] dirs = new int[][]{{-1, 0}, {1,0},{0,-1},{0,1}};
//         HashSet<int[]> seen = new HashSet();
//         Queue<int[]> q = new LinkedList();
//         int m = grid.length;
//         int n = grid[0].length;
//         for ( int i = 0; i < m; i++)
//         {
//             for( int j = 0; j < n; j++)
//             {
//                 if (grid[i][j] == '*')
//                 {
//                     q.add(new int[]{i,j});
//                     seen.add(new int[]{i,j});
//                     break;
//                 }
//             }
//         }
//         int step = 0;
//         while (!q.isEmpty())
//         {
//             int size = q.size();
//             for ( int i = 0; i < size; i++)
//             {
//                 int[] cur = q.poll();
//                 for ( int[] dir : dirs)
//                 {
//                     int r = cur[0] + dir[0];
//                     int c = cur[1] + dir[1];
//                     if ( r < m && c < n && r >= 0 && c >=0 && grid[r][c] != 'X' && !seen.contains(new int[]{r,c}))  
//                     {
//                         if (grid[r][c] == '#')
//                             return step+1;
//                         q.add(new int[]{r,c});
//                         seen.add(new int[]{r,c});
//                     }    
//                 }
//             }
//             step++;   
//         }
//        return -1; 
