class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0;
        int count = 0;
        int product = 1;
        if ( k <= 1) return 0;
        
        for ( int end = 0; end < nums.length; end++)
        {
            product = product * nums[end];
            while (product >= k && start < nums.length)
            {
                product = product/nums[start++];
                
            }
            count = count + (end - start + 1);
        }
        return count;
    }
}