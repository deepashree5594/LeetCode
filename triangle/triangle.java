class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;
    
        int result = 0;
        int[] dp = new int[triangle.size()];
        
        //populating last row
        for (int j = 0; j < dp.length; j++)
            dp[j] = triangle.get(dp.length-1).get(j);
        
        // DP bottom up- start from second-last row
        for ( int i = dp.length - 2; i >=0; i-- ) {
            for ( int j = 0; j <= i; j++) {
               dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
         }
       }
       return dp[0];
    }
}