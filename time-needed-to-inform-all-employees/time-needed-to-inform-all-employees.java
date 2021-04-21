//BFS
//TC:O(N)
//SC:O(depth of hierarchy)
//Did it run successfully on Leetcode?:Yes
class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (manager == null || manager.length == 0)
            return 0;
        List<List<Integer>> subordinatesList = new ArrayList();
       for (int i = 0; i < n; i++){
               subordinatesList.add(new ArrayList());
        }
        System.out.println(subordinatesList);
        for (int i = 0; i < manager.length; i++){
            if (manager[i] == -1)
                continue;
            subordinatesList.get(manager[i]).add(i);
        } 
        Queue<int[]> q = new LinkedList();
        HashSet<Integer> visited = new HashSet();
        q.offer(new int[]{headID, informTime[headID]});
        // visited.add(headID);
        int maxTime = Integer.MIN_VALUE;
        while (!q.isEmpty()){
                int[] curr = q.poll();
                int employee = curr[0];
                int time = curr[1];
                maxTime = Math.max(maxTime, time);
                List<Integer> reports = subordinatesList.get(curr[0]);
                if (reports != null){
                    for (int report : reports){
                         // if (!visited.contains(report)){
                             q.offer(new int[]{report, time + informTime[report]});
                             // visited.add(report);
                         // }
                    }
                }
            }
        
        return maxTime;
    }
}

//DFS
//TC:O(N)
//SC:O(depth of hierarchy)
//Did it run successfully on Leetcode?:Yes
// class Solution {
//     List<List<Integer>> subordinatesList;
//     public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
//         if (manager == null || manager.length == 0)
//             return 0;
//         subordinatesList = new ArrayList();
//         // build the adjacency list -> manager: all his/her subordinates           -> Assumed : subordinates = direct reports
//         for (int i = 0; i < n; i++){
//                subordinatesList.add(new ArrayList());
//         }
//         for (int i = 0; i < manager.length; i++){
//             if (manager[i] == -1)
//                 continue;
//             subordinatesList.get(manager[i]).add(i);
//         } 
//         return dfs(informTime, headID, 0);
//     }
//     private int dfs(int[] informTime, int currID, int maxSubordinateInformTime){
//         //get all the subordinates of the current person
//         for (int subordinate : subordinatesList.get(currID)){
//             // take the max inform time among all his subordinates
//             maxSubordinateInformTime = Math.max(maxSubordinateInformTime, dfs(informTime, subordinate, 0));
//         }
//         // max inform time among all his subodinates + inform time of current person
//         return maxSubordinateInformTime + informTime[currID];
//     }
// }