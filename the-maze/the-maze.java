// class Solution {
//     public boolean hasPath(int[][] maze, int[] start, int[] destination) {
//         if ( maze == null || maze.length == 0)
//             return false;
//         Queue<int[]> q = new LinkedList();
//         q.add(start);
        
//         int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
//            int m = maze.length;
//            int n = maze[0].length;
//         HashSet<int[]> seen = new HashSet();
//         seen.add(new int[]{start[0], start[1]});
//         while (!q.isEmpty())
//         {
//             int[] cur = q.poll();
            
//             if (cur[0] == destination[0] && cur[1] == destination[1])
//                 return true;
//             for ( int[] dir : dirs)
//             {
//                 int r = dir[0] + cur[0];
//                 int c = dir[1] + cur[1];
//                 while ( r >= 0 && c >= 0 && r < m && c < n && maze[r][c] == 0)
//                 {
//                     r = r + dir[0];
//                     c = c + dir[1];
//                 }
//                     if (!seen.contains(new int[]{r - dir[0] ,c - dir[1]}))
//                     {    q.add(new int[]{r - dir[0] ,c - dir[1]});
//                          seen.add(new int[]{r - dir[0] ,c - dir[1]});
//                     }
//                 }
//          }
//      return false;
//     }
public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] dirs={{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue < int[] > queue = new LinkedList < > ();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] s = queue.remove();
            if (s[0] == destination[0] && s[1] == destination[1])
                return true;
            for (int[] dir: dirs) {
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                if (!visited[x - dir[0]][y - dir[1]]) {
                    queue.add(new int[] {x - dir[0], y - dir[1]});
                    visited[x - dir[0]][y - dir[1]] = true;
                }
            }
        }
        return false;
    }
}
// }