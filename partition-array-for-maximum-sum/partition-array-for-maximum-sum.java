class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if ( arr == null || arr.length == 0)
            return 0;
        int dp[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            int max = arr[i];
            for (int j = 1; j <= k && i-j+1 >= 0; j++){
                //incoming element = arr[i-j+1]
                max = Math.max(max, arr[i-j+1]);
                if (i-j >= 0){
                     dp[i] = Math.max(dp[i], dp[i-j] + max * j);
                }else {
                    dp[i] = Math.max(dp[i], max * j);
                }              
            }
        }
        return dp[dp.length-1];
    }
}