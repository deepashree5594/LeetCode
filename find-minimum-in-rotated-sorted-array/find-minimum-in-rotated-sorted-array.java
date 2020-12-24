// Bruteforce approach - O(n)
//class Solution {
//     public int findMin(int[] nums) {
//         int min = nums[0];
//         for ( int i = 1; i < nums.length; i++)
//         {
//             min = Math.min(min, nums[i]);
//         }
//         return min;
//     }
// }
​
​
​
// Binary Search way - O(logn)
class Solution {
    public int findMin(int[] nums) {
      int min = Integer.MAX_VALUE;
      int low = 0;
      int high = nums.length-1 ;
      while (low <= high)
      {
          int mid = low + (high-low)/2;
          min = Math.min(min, nums[mid]);
          if(nums[low] <= nums[mid])
          {
              if(nums[low] <= nums[high] && nums[mid] <= nums[high])
              {
                  high = mid - 1;
              }
              else
              {
                  low = mid + 1;
              }
          }
          else
          {
              if (nums[low] >= nums[high] && nums[mid] <= nums[high])
              {
                  high = mid - 1;
              }
              else
              {
                  low = mid + 1 ;
              }
          }
      }
      return min;
    }
}
