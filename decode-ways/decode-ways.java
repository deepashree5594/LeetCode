class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;       
        int dp[] = new int[s.length() + 1];
        
        // no. of ways to decode 0 is 0 as there is no mapping for 0.
        dp[0] = 1;       
        dp[1] =  (s.charAt(0) == '0')? 0: 1;
​
        for (int i = 2; i < dp.length; i++)
        {
            // single digit decoding
            if (s.charAt(i-1) != '0')
               dp[i] = dp[i] + dp[i-1];
            // double digit decoding
            
            int digit = Integer.valueOf(s.substring(i-2, i));
            if (digit >= 10 && digit <= 26)
                dp[i] = dp[i] + dp[i-2];
        }
           return dp[dp.length-1]; 
    }
}
