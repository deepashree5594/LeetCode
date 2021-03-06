// TC: O(N)
// SC: O(1) 
// Did it run successfully on Leetcode? : Yes
class Solution {
 public int jump(int[] nums) {
     int n = nums.length;
     if(nums == null || nums.length == 0)
            return 0;
     if (n < 2) 
        return 0;    
     int jumps = 1;
     int curr_interval = nums[0];
     int next_interval = nums[0];
     for (int i = 1; i < n; i++)
     {
         next_interval = Math.max(next_interval, i + nums[i]);
         if (i < nums.length-1 && curr_interval == i)
         {
             curr_interval = next_interval;
             jumps++;
         }
     }
     return jumps; 
   }
}
// 0 1 2 3 4
// 2,3,1,1,4

// DFS - TLE
// TC: Exponential
// SC: O(N) -> recursive stack size
// Did it run successfully on Leetcode? : TLE
// class Solution {
//     int min;
//     public int jump(int[] nums) {
//         if(nums == null || nums.length == 0)
//             return 0;
//         min = Integer.MAX_VALUE;
//         dfs(nums, 0, 0);
//         return min;
//     }
//     private void dfs(int[]nums, int index, int jumps)
//     {
//         //base
//         if ( index >= nums.length -1)
//         {
//             min = Math.min(min, jumps);
//             return;
//         }
//         //logic
//         for ( int j = 1; j <= nums[index]; j++)
//         {
//             dfs(nums, j + index, jumps + 1);
                
//         }
//     }
// }