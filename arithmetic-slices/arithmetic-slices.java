class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int result = 0;
        for ( int i = 0; i < nums.length - 1; i++)
        {
            int difference = nums[i+1] - nums[i];
            for ( int j = i+1; j < nums.length - 1; j++)
            {
                if (nums[j+1] - nums[j] == difference)
                    result++;
                else
                    break;
            }
        }
        return result;
    }
}