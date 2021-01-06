// class Solution {
//     public int numWays(int n, int k) {
//     if (n == 0 || k == 0)
//         return 0;
//         return helper(n, k, 1, 0);
//     }
    
//     private int helper(int n, int k, int index, int count)
//     {
//         //base case
        
//           if (index > n || k < 0)
//             return count;
//         //logic
//         //choose
//         int case1 = helper(n, k-1);
//         //dont choose
//         int case2 = helper(n, k);
        
        
//     }
    
// }
​
class Solution {
    public int numWays(int n, int k) {
        if ( n == 0)
            return 0;
        if (n == 1)
            return k;
        if (n == 2)
            return k*k;
        int[] dp = new  int[n+1];
        dp[1] = k;
        dp[2] = k*k;
        for ( int i = 3; i <=n; i++)
        {
            dp[i] = (dp[i-1] + dp[i-2]) *(k-1);
        }
        return dp[dp.length-1];
    }
}
