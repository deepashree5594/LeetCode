//TC:O(N)
//SC:O(1)
//Did it run successfully on Leetcode?:Yes
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        int prev = 0;
        int result = 0;
        for ( int i = 2; i < nums.length; i++){
            if (nums[i-1] - nums[i] == nums[i-2] - nums[i-1]){
                prev = prev+1;
                result = result + prev;
            }else{
                prev = 0;
            }
        }
        return result;
    }
}