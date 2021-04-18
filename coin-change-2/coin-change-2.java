class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for ( int i = 0; i < dp.length; i++ ){
            dp[i][0] = 1;
        }
        for (int i = 1; i < dp.length;i++){
            for (int j = 1; j < dp[0].length; j++){
                if (j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}

// class Solution {
//     public int change(int amount, int[] coins) {
//         if (coins == null || coins.length == 0)
//             return 0;
//         return helper(coins, 0, amount, noOfWays);
//     }
//     private int helper(int[] coins, int index, int amount){
//         //base
//         if (index >= coins.length && amount != 0)
//             return -1;
//         if (amount == 0){
//             return 
//         }
//         //logic
//         //case1 - choose
//         int case1 = helper(coins, index+1, amount - coins[index]);
//         //case2 - don't choose
//         int case2 = helper(coins, index+1, amount);
//         return case1+case2;
//     }
// }