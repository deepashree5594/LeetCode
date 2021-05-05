class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int[] lefSum = new int[k+1];
        int[] rightSum = new int[k+1];
        int maxScore = 0;
        for (int i = 0; i < k; i++){
            lefSum[i+1] = cardPoints[i] + lefSum[i];
            rightSum[i+1] = cardPoints[n - i - 1] + rightSum[i];
        }
        for (int i = 0; i <= k ; i++){
            int currScore = lefSum[i] + rightSum[k-i];
            maxScore = Math.max(currScore, maxScore);
        }
        return maxScore;
    }
}

