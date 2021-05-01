//TC:O(E)
//SC:O(V)
class Solution {
    public int findJudge(int N, int[][] trust) {
        if (trust.length < N-1)
            return -1;
        int[] trustScores = new int[N+1];
        for (int[] relation : trust){
            //outdegree
            trustScores[relation[0]]--;
                
            //indegree
            trustScores[relation[1]]++;
        }
        for (int i = 1; i <= N; i++){
            if (trustScores[i] == N-1)
                return i;
        }
        return -1;
    }
}