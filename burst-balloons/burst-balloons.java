class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[][] dp = new int[n][n];
        // length of decision arrays
        for (int len = 1; len <= n; len++){
            for ( int i = 0; i <= n-len; i++){
                int j = i + len - 1;
                for (int k = i; k <= j; k++){
                    int left = 1;
                    int right = 1;
                    if (i != 0){
                        left = nums[i-1];
                    }
                    if (j != n-1){
                        right = nums[j+1];
                    }
                    int before = 0;
                    int after = 0;
                    if ( i != k){
                         before = dp[i][k-1];
                    }
                    if (j != k){
                         after = dp[k+1][j];
                    }
                    dp[i][j] = Math.max(dp[i][j], before + (left * nums[k]* right) + after);
                }
            }
        }
          return dp[0][n-1];  
    }
}