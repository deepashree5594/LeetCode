// Time Complexity : Binary Search - O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
​
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if ( nums == null || nums.length == 0) return new int[]{-1, -1};
  
        int first = binarySearchFirst(nums, target);
        int second = binarySearchSecond(nums, target);
        return new int[]{first, second};
      }
​
      private int binarySearchFirst(int[] nums, int target)
      {
          int low = 0;
          int high = nums.length-1;
          while ( low <= high)
          {
              int mid = low + (high-low)/2;
              if (nums[mid] == target)
              {
                  if (mid == 0 || nums[mid] > nums[mid-1])
                      return mid;
                  else
                      high = mid -1;
              }
              else if (nums[mid] > target)
              {
                  high = mid - 1;
              }
              else
              {
                  low = mid + 1;
              }
          }
         return -1;
      }
    
      private int binarySearchSecond(int[] nums, int target)
      {
          int low = 0;
          int high = nums.length-1;
          while ( low <= high)
          {
              int mid = low + (high-low)/2;
              if (nums[mid] == target)
              {
                  if (mid == nums.length-1 || nums[mid+1] > nums[mid])
                      return mid;
                  else
                      low = mid + 1;
              }
              else if (nums[mid] > target)
              {
                  high = mid - 1;
              }
              else
              {
                  low = mid + 1;
              }
          }
         return -1;
      }
}
// Time Complexity : Linear Search - O(2N) - O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
