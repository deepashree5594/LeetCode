class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] row : dp)
            Arrays.fill(row, 0);
        
        for ( int i = 0; i<s.length(); i++)
        {
            dp[i][i] = 1;
        }
        // int j;
        // for ( int k = 2; k <= s.length(); k++)
        // {
        //     for (int i = 0; i< s.length()- k +1; i++)
        //     {
        //         j = i + k - 1;
        //         if (s.charAt(i) == s.charAt(j) && k ==2)
        //             dp[i][j] = 2;
        //         else if (s.charAt(i) == s.charAt(j))
        //             dp[i][j] = dp[i+1][j-1] + 2;
        //         else
        //             dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
        //     }
        // }
        for (int i = 1; i < dp.length; i++)
        {
            for (int j = i-1; j >= 0; j--)
            {
               
                 if (s.charAt(i) == s.charAt(j))
                 {
                   dp[i][j] = 2 + dp[i-1][j+1];
                 } 
                 else
                 {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j+1]);   
                 }  
               
            }
        }
         return dp[n-1][0];
        
        
        // return dp[0][s.length()-1];
    }
}