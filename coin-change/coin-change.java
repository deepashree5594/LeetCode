class Solution {
    public int coinChange(int[] coins, int amount) {
        if ( coins == null || coins.length == 0)
               return 0;
        int[][] dp = new int[coins.length+1][amount+1];
        Arrays.fill(dp[0], amount+1);
        for (int i = 1; i < dp.length; i++){
            for ( int j = 1; j < dp[0].length; j++){
                if (j < coins[i-1]  ){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                }
            }
        }
        int result = dp[dp.length-1][dp[0].length-1];
        if (result >= amount+1)
            return -1;
        return result;
    }
}
// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         if (coins == null || coins.length == 0)
//             return 0;
//         int[][] dp = new int[coins.length+1][amount+1];
//         Arrays.fill(dp[0], amount+1);
//         for (int i = 1; i < dp.length; i++) {
//             for (int j = 1; j < dp[0].length; j++) {
//                 // if the amount is less than the coin value, just copy the value from above
//                 if (j < coins[i-1]){
//                     dp[i][j] = dp[i-1][j];
//                 }
//                 else{
//                    // Min between (1+same row, colum - coin val, upper row val)
//                     dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j - coins[i-1]]);
//                 }
//             }
//         }
//         int result = dp[dp.length-1][dp[0].length-1];
//         // if combination is impossible return -1
//         if (result >= amount+1){
//             return -1;
//         }
//         return result;
//     }
// }
//TC: O(2^N)
//SC: O(N)
//Did it run successfully on Leetcode?:Yes
// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         if ( coins == null || coins.length == 0)
//             return 0;
//         return helper(coins, 0, amount, 0);
//     }
//     private int helper(int[] coins, int index, int amount, int minNoOfCoins ){
//         //base
//         if ( amount == 0){
//             return minNoOfCoins;
//         }
//         if (index >= coins.length || amount < 0){
//             return -1;
//         }
//         //logic
        
//         //choose
//         int case1 = helper(coins, index, amount-coins[index], minNoOfCoins+1);
        
//         //dont choose
//         int case2 = helper(coins, index+1, amount, minNoOfCoins);
        
//         if ( case1 == -1){
//             return case2;
//         }
//         if ( case2 == -1){
//             return case1;
//         }
//         return Math.min(case1, case2);           
//     }
// }