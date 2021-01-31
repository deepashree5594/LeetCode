class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int i = 0;
        int j = A.length-1;
        int max = -1;
        while ( i < j)
        {
            int sum = A[i] + A[j];
            if ( sum < K)
            {
                max = Math.max(max, sum);
                i++;
            }
            else
            {
                j--;
            }
        }
        return max;
    }
}