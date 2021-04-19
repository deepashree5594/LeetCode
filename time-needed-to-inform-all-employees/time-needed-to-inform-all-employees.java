class Solution {
    List<List<Integer>> subordinatesList;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (manager == null || manager.length == 0)
            return 0;
        subordinatesList = new ArrayList();
        for (int i = 0; i < n; i++){
               subordinatesList.add(new ArrayList());
        }
        for (int i = 0; i < manager.length; i++){
            if (manager[i] == -1)
                continue;
            subordinatesList.get(manager[i]).add(i);
        } 
        return dfs(informTime, headID);
    }
    private int dfs(int[] informTime, int currID){
        int maxSubordinateInformTime = 0;
        for (int subordinate : subordinatesList.get(currID)){
            maxSubordinateInformTime = Math.max(maxSubordinateInformTime, dfs(informTime, subordinate));
        }
        return maxSubordinateInformTime + informTime[currID];
    }
}