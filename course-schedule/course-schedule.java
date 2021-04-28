class Solution {
    HashMap<Integer, List<Integer>> graph;
    int[] inDegree;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0)
            return true; 
        inDegree = new int[numCourses];
        graph = buildGraph(prerequisites,numCourses );
        
        //BFS -> topological sorting
        Queue<Integer> q = new LinkedList();
        for ( int i = 0; i < numCourses; i++){
            if (inDegree[i] == 0){
                q.offer(i);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;
            List<Integer> dependencies = graph.get(curr);
            if (dependencies != null){
              for (int dependency : dependencies){
                inDegree[dependency]--;
                if (inDegree[dependency] == 0)
                    q.offer(dependency);
              }
            }
        }
        return count == numCourses;
    }
    private HashMap<Integer, List<Integer>> buildGraph(int[][] prerequisites, int numCourses){
        HashMap<Integer, List<Integer>> map = new HashMap();
        for (int[] prerequisite : prerequisites){
            if (!map.containsKey(prerequisite[1])){
                map.put(prerequisite[1], new ArrayList());
            }
            map.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }
        return map;
    }
}