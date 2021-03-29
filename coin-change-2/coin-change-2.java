// TC: O(2^N) -> Recursive solution 
// SC: O(N) -> recursive stack space
// Did it run successfully on Leetcode? : TLE
// class Solution {
//     public int change(int amount, int[] coins) {
//         return helper(coins, 0, amount);
//     }
//     private int helper(int[] coins, int index, int amount){
//         //base
//         if (amount == 0){
//             return 1;
//         }
//         if (amount < 0 || index >= coins.length){
//             return 0;
//         }  
//         //logic
//         //dont choose
//         int case1 = helper(coins, index, amount-coins[index]);
//         //choose
//         int case2 = helper(coins, index+1, amount);
//         return case1+case2;
//     }
// }

// Bottom up DP 
// TC: O(M*N) -> O(coins.length + 1 * amount +1 ) 
// SC: O(M*N) -> dp matrix size
// Did it run successfully on Leetcode? : Yes
class Solution {
    public int change(int amount, int[] coins) {
       int[][] dp = new int[coins.length+1][amount+1];
        for (int i = 0; i < dp.length; i++){
            dp[i][0] = 1;
        }
         for (int i = 1; i < dp.length; i++){
             for (int j = 1; j < dp[0].length; j++){
                 if (j < coins[i-1]){
                     dp[i][j] = dp[i-1][j];
                 }else{
                     dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                 }
             }
         }
        return dp[dp.length-1][dp[0].length-1];
    }
}