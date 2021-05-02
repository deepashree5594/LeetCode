class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int lastGoodPosition = n-1;
        for (int i = n-1; i>=0; i--){
            if ( i + nums[i] >=  lastGoodPosition){
                lastGoodPosition = i;
            }
            if (lastGoodPosition == 0)
                return true;
        }
        return false;
    }
}