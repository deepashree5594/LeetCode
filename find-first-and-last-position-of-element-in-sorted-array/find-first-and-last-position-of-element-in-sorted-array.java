class Solution {
    public int[] searchRange(int[] nums, int target) {
        if ( nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int[] res = new int[2];
        res[0] = firstBinarySearch(nums, target);
        res[1] = secondBinarySearch(nums, target);
        return res;
    }
    private int firstBinarySearch(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        while ( low <= high){
            int mid = low + (high-low)/2;
            if (nums[mid] == target){
                if(mid == 0 || nums[mid-1] < nums[mid]){
                    return mid;
                } else if (nums[mid-1] == nums[mid]){
                    high = mid - 1;
                } else {
                    low = mid +1;
                }
            } else if (nums[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1 ;
            }
        }
        return -1;
    }
    private int secondBinarySearch(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        while ( low <= high){
            int mid = low + (high-low)/2;
            if (nums[mid] == target){
                if(mid == nums.length-1 || nums[mid] < nums[mid+1]){
                    return mid;
                }  else if (nums[mid] == nums[mid + 1]){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1 ;
            }
        }
        return -1;
    }
}