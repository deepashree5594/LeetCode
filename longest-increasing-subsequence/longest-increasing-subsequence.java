class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[] effectiveIncreasingArray = new int[n];
        int len = 1;
        effectiveIncreasingArray[0] = nums[0];
        for (int i = 1; i < n; i++){
            if (nums[i] > effectiveIncreasingArray[len-1]) {
                effectiveIncreasingArray[len] = nums[i];
                len++;
            } else {
                int index = closesBinarySearch(0, len, effectiveIncreasingArray, nums[i]);
                effectiveIncreasingArray[index] = nums[i];   
            }
        }
        return len;
    }
    private int closesBinarySearch(int low, int high, int[] arr, int target){
        while (low <= high){
            int mid = low + (high-low)/2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target){
                 low = mid+1;
            } else 
                high = mid-1;
        }
        return low;
    }
}