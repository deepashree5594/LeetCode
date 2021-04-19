class Solution {
    int min = Integer.MAX_VALUE;
    public int openLock(String[] deadends, String target) {
        if (deadends == null || deadends.length == 0 )
            return 0;
        HashSet<String> deadSet = new HashSet<String>();
        for (String s : deadends){
            deadSet.add(s);
        }
        String start = "0000";
        if (deadSet.contains(start))
            return -1;
        HashSet<String> visited = new HashSet();
        Queue<String> q = new LinkedList();
        visited.add(start);
        q.offer(start);
        int minSteps = 0;
        
        while (!q.isEmpty()){
            int size = q.size();
           
            for (int i = 0; i < size; i++){
                String curr = q.poll();
                if (curr.equals(target))
                    return minSteps;
                if (!deadSet.contains(curr)){
                //     continue;
                // }
                for ( int index = 0; index < 4; index++){
                   for ( int d = -1; d <= 1; d = d + 2){
                            int y = ((curr.charAt(index) - '0') + d + 10) % 10;
                            String nextCombination = curr.substring(0, index) + y + curr.substring(index+1);
                            // if (nextCombination.equals(target))
                            //     return minSteps;
                            if (!visited.contains(nextCombination)){
                                q.offer(nextCombination);
                                visited.add(nextCombination);
                            }
                        }
                    }
                }             
            }
             minSteps++;
        }
        return -1;
    }
}
