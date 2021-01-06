//TC: O(N) - n is the no. of elements in nums array
//SC: O(N)
// Did it run successfully on LeetCode? : 
class Solution {
    public int rob(int[] nums) {
       if (nums == null || nums.length == 0)
             return 0;
       int dp[][] = new int[nums.length+1][2];
       dp[0][0] = 0;
       dp[0][1] = 0;
       for ( int i = 1; i < dp.length; i++)
       {
               dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
               dp[i][1] = dp[i-1][0] + nums[i-1];          
       }
        return Math.max(dp[dp.length-1][0],dp[dp.length-1][1]);
    }
    
}
​
​
​
// Recursion
//TC: O(2^N) - n is the no. of elements in nums array
//SC: O(1)
// Did it run successfully on LeetCode? : TLE
// class Solution {
//     public int rob(int[] nums) {
//        if (nums == null || nums.length == 0)
//              return 0;
//         return helper(nums, 0, 0);
//     }
//     private int helper(int[] nums, int index, int amount)
//     {
//         //base case
//         if ( index >= nums.length)
//             return amount;     
//         //logic
        
//         //choose
//         int case1 = helper(nums, index+2, amount + nums[index]);
//         // dont choose
//         int case2 = helper(nums, index+1, amount);
//         return Math.max(case1, case2);
//     }
// }
​
