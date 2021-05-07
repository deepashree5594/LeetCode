//[1,2,3,7]
//[1,2,3,-9]

// 0 1 2 3  4
//       7  
class Solution {
    public String stoneGameIII(int[] A) {
        int n = A.length;
        int[] dp = new int[n+1];
        for (int i = n-1; i >= 0; i--){
            dp[i] = Integer.MIN_VALUE;
            for ( int k = 0, take = 0; k < 3 && i + k < n; k++){
                take = take + A[i+k];
                dp[i] = Math.max(dp[i], take - dp[i+k+1]);
            }
            
        }
        if (dp[0] < 0)
            return "Bob";
        else if (dp[0] > 0)
            return "Alice";
        return "Tie";
    }
}


// dp[i] means, if we ignore before A[i],
// what's the highest score that Alex can win over the Bob？

// There are three option for Alice to choose.
// Take A[i], win take - dp[i+1]
// Take A[i] + A[i+1], win take - dp[i+2]
// Take A[i] + A[i+1] + A[i+2], win take - dp[i+3]