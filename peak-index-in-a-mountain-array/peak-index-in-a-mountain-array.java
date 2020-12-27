class Solution {
    public int peakIndexInMountainArray(int[] A) {
       int low = 0;
       int high = A.length-1;
         
        while ( low <= high)
        {
            int mid = low + (high-low)/2;
            if ( (mid == 0 || A[mid] > A[mid-1]) && (mid == A.length-1 || A[mid] > A[mid+1]))
                return mid;
            else if ( A[mid] < A[mid+1])
            {
                low = mid +1;
            }
            else
            {
                high = mid -1 ;
            }
                
        }
        return -1;
    }
}
