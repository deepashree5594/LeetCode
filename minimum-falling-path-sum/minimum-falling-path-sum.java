class Solution {
    public int minFallingPathSum(int[][] matrix) {
       if (matrix == null || matrix.length == 0)
           return 0;
        for ( int i = matrix.length-2; i>=0; i--){
            for ( int j = 0; j < matrix[0].length; j++){
                 int sum = matrix[i+1][j];
                if ( j > 0){
                    sum = Math.min(sum, matrix[i+1][j-1]);
                }
                if (j+1 < matrix[0].length){
                    sum = Math.min(sum, matrix[i+1][j+1]);    
                }
                 matrix[i][j] = matrix[i][j] + sum;
            }
        }
        // return the minimum in the first row
        int minSum = Integer.MAX_VALUE;
        for (int n : matrix[0]){
            minSum = Math.min(minSum, n);
        }
        return minSum;
    }
}