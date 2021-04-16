class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;
         int[] effectiveIncreasingSequenceArray = new int[nums.length];
         int len = 1;
         effectiveIncreasingSequenceArray[0] = nums[0];
         for (int i = 1; i < nums.length; i++){
             if (nums[i] >  effectiveIncreasingSequenceArray[len-1]){
                 effectiveIncreasingSequenceArray[len] = nums[i];
                 len++;  
             }
             else {
                 int index = closestBinarySearch(effectiveIncreasingSequenceArray, 0, len, nums[i]);
                 effectiveIncreasingSequenceArray[index] = nums[i];
             }
         }
         return len >= 3;   
    }
    private int closestBinarySearch(int[] effectiveIncreasingSequenceArray, int low, int high, int target){
        while ( low <= high){
            int mid = low + (high-low)/2;
            if (effectiveIncreasingSequenceArray[mid] == target)
                return mid;
            else if (effectiveIncreasingSequenceArray[mid] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}