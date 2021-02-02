class Solution {
    int target;
    int[][] graph;
    List<List<Integer>> result;
    
    public void backtrack(List<Integer> path, int currentNode)
    {
        if (currentNode == this.target)
        {
            this.result.add(new ArrayList<>(path));
            return;
        }
        
        for (int nextNode: graph[currentNode])
        {
            // action
            path.add(nextNode);
            
            // recurse
            backtrack(path, nextNode);
            
            //backtrack
            
            path.remove(path.size() -1 );
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
         this.target = graph.length - 1;
         this.graph = graph;
         this.result = new ArrayList<List<Integer>>();
         List<Integer> path = new ArrayList<Integer>();
         path.add(0);
         this.backtrack(path, 0);
        
         return this.result;
    }
}

// Input: graph = [[1,2],[3],[3],[]]
// Output: [[0,1,3],[0,2,3]]
// Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.