// DP
// TC: O(N)
// SC: O(N)
// Did it run successfully on Leetcode? : Yes
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int result = 0;
        int[] dp = new int[nums.length];
        for (int i = 2; i < dp.length ; i++){
            if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2] ){
                dp[i] = 1 + dp[i-1];
                result = result + dp[i];
            }
        }
        return result;
    }
}
// Bruteforce
// TC: O(N*N)
// SC: O(1)
// Did it run successfully on Leetcode? : Yes
// class Solution {
//     public int numberOfArithmeticSlices(int[] nums) {
//         if (nums == null || nums.length == 0)
//             return 0;
//         int result = 0;
//         for ( int i = 0; i < nums.length - 1; i++)
//         {
//             int difference = nums[i+1] - nums[i];
//             for ( int j = i+1; j < nums.length - 1; j++)
//             {
//                 if (nums[j+1] - nums[j] == difference)
//                     result++;
//                 else
//                     break;
//             }
//         }
//         return result;
//     }
// }