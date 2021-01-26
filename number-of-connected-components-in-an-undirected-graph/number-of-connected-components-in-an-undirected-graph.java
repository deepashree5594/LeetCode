//https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/discuss/77574/Easiest-2ms-Java-Solution
class Solution {
    public int countComponents(int n, int[][] edges) {
    HashMap<Integer, List<Integer>> map = new HashMap();
    for ( int[] edge: edges)
    {
        if (!map.containsKey(edge[0]))
            map.put(edge[0], new ArrayList());
        map.get(edge[0]).add(edge[1]);
        if (!map.containsKey(edge[1]))
            map.put(edge[1], new ArrayList());
        map.get(edge[1]).add(edge[0]);
        
    }
    HashSet<Integer> seen = new HashSet();
    int connectedComponents = 1;
    for (int i = 0; i < n; i++)
    {
        if (!seen.contains(i))
        {
            connectedComponents++;
            // bfs()
            Queue<Integer> q = new LinkedList();
            q.add(i);
            while (!q.isEmpty())
            {
                int vertex = q.poll();
                seen.add(vertex);
                List<Integer> neigbors = map.get(vertex);
               if (neigbors != null)
               {
                 for (int neigbhor : neigbors)
                 {
                    if (!seen.contains(neigbhor))
                    {
                        q.add(neigbhor);
                    }
                  }
               }
            } 
        }
      }
   return connectedComponents-1;
    }
}
