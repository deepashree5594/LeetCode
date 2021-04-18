class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[][] dp = new int[nums.length+1][2];
        for (int i = 1; i < dp.length; i++){
            for (int j = 0; j < dp[0].length; j++){
                if (j == 0){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j+1]);
                } else {
                     dp[i][j] = nums[i-1] + dp[i-1][j-1];
                }
            }
        }
        return Math.max(dp[dp.length-1][0], dp[dp.length-1][1]);
    }
}