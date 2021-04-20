class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        List<Integer> lastRow = triangle.get(m-1);
        int[] dp = new int[m+1];
        for ( int i = m-1; i>=0; i--){
         for (int j = 0; j <= i; j++){
             dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
          }
        }
      return dp[0];
    }
}