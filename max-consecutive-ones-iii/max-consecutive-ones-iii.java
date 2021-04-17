class Solution {
    public int longestOnes(int[] nums, int k) {
        if ( nums == null || nums.length == 0)
            return 0;
        int left = 0;
        int result = 0;
        for (int right = 0; right < nums.length; right++){
            if (nums[right] == 0){
                k--;
            }
            if (k < 0){
                if (nums[left] == 0){
                    k++;
                }
                left++;   
                }
             result = Math.max(result, right - left + 1);
            }
        return result;
    }
}