//TC:O(N)
//SC:O(1)
//Did it run successfully on Leetcode?:Yes
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for ( int i = 0; i < nums.length; i++)
        {
            ans = ans ^ nums[i];
        }
        return ans;
    }
}