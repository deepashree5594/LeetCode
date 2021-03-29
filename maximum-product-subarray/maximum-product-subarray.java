class Solution {
    public int maxProduct(int[] nums) {
       int max = nums[0];
       int min = nums[0];
       int product = nums[0];
       for( int i = 1; i < nums.length; i++){
           int temp_max = max;
           int temp_min = min;
           max = Math.max(nums[i], Math.max(nums[i] * temp_max, nums[i] * temp_min));
           min = Math.min(nums[i], Math.min(nums[i] * temp_max, nums[i] * temp_min));
           product = Math.max(product, Math.max(max, min));
       }
        
      return product;
    }
}
