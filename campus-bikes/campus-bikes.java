class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        if (workers == null || workers.length == 0 || bikes == null || bikes.length == 0)
            return new int[]{};
        int[] workersAssignedBikes = new int[workers.length];
        Arrays.fill(workersAssignedBikes, -1);
        boolean[] bikeAssigned = new boolean[bikes.length];
        List<int[]>[] arrayOfList = new List[2000];
        for (int i = 0; i < workers.length; i++){
            for (int j = 0; j < bikes.length; j++){
                int distance = calulateManhattanDistance(workers[i], bikes[j]);
                if (arrayOfList[distance] == null)
                  arrayOfList[distance] = new ArrayList();
                arrayOfList[distance].add(new int[]{i, j});
            }
        }
        for ( int i = 0; i < 2000; i++){
            List<int[]> list = arrayOfList[i];
            if ( list != null){
                for (int[] workerBikePair : list){
                    int worker = workerBikePair[0];
                    int bike = workerBikePair[1];
                    if (workersAssignedBikes[worker] == -1 && !bikeAssigned[bike]){
                        workersAssignedBikes[worker] = bike;
                        bikeAssigned[bike] = true;
                    }
                }
            }
        }
        return workersAssignedBikes;
    }
    private int calulateManhattanDistance(int[] W, int[] B){
        return Math.abs(W[0] - B[0]) +  Math.abs(W[1] - B[1]);
    }
}