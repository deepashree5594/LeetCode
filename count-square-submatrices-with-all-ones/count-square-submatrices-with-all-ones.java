class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;            
        int[][] dp = new int[m][n];
        //fill first row
        for ( int j = 0; j < n; j++){
            dp[0][j] = matrix[0][j];
            count = count + dp[0][j]; 
        }
        //fill first column
        for ( int i = 1; i < m; i++){
            dp[i][0] = matrix[i][0];
            count = count + dp[i][0]; 
        }
        for ( int i = 1; i < m; i++){
            for ( int j = 1; j < n; j++){
                if (matrix[i][j] == 1){
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
                    count = count + dp[i][j];
                }
                
            }
        }
        return count;
    }
}