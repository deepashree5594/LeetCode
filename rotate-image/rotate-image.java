class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        int m = matrix.length;
        int n = matrix[0].length;
        // transpose the matrix
        for (int i = 0; i < m; i++){
            for (int j = i; j < n; j++){
                swap(matrix, i, j);
            }
        }
        // swap the elements of each row
        for (int[] row : matrix){
            int i = 0;
            int j = n-1;
            while ( i < j){
                int temp = row[i];
                row[i] = row[j];
                row[j] = temp;
                i++;
                j--;
            }
        }
    }
    private void swap(int[][] matrix, int i, int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}