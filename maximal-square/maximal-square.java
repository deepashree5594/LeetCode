class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
               return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flag = false;
        int max = 0;
        for ( int i = 0; i < m; i++)
        {
            for ( int j = 0; j < n; j++)
            {
                if (matrix[i][j] == '1')
                {
                    flag = true;
                    int curr = 1;
                    while (i + curr < m && j + curr < n && flag)
                    {
                        // now at = i+curr and j+curr index
                        // check in same column if we have '0'
                        for (int k = i + curr; k >= i ; k--)
                        {
                            if(matrix[k][j+curr] == '0')
                            {
                                flag = false;
                                break;
                            }
                        }
                        // check in same row if we have '0'
                        for (int k = j + curr; k >= j ; k--)
                        {
                            if(matrix[i+curr][k] == '0')
                            {
                                flag = false;
                                break;
                            }
                        }
                        if (flag)
                          curr++;
                    }
                     max = Math.max(max, curr);  // curr will have length of squarefound at i, j
                } 
            }
        }
       return max * max;
    }
}