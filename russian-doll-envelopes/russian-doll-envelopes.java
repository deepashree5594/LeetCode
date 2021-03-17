// Binary Search 
// TC: O(NlogN) -> worst case do binary serach N times
// SC: O(N)
// Did it run successfully on Leetcode? : Yes
// class Solution {
//     public int maxEnvelopes(int[][] envelopes) {
//         if ()
//     }
// }




// DP 
// TC: O(N^2)
// SC: O(N)
// Did it run successfully on Leetcode? : Yes
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0)
            return 0;
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        Arrays.sort(envelopes, (a,b) -> a[0] - b[0]);
        int result = 1;
        
        for (int i = 1; i < dp.length; i++)
        {
            for ( int j = 0; j < i; j++)
            {
                if (envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0])
                {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    result = Math.max(result, dp[i]);
                }
            }
        }
        return result;
        
    }
}