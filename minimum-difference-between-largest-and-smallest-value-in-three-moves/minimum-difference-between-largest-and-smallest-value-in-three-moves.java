// /[2,3,4,5]
class Solution {
    public int minDifference(int[] nums) {
        if (nums == null || nums.length < 5)
            return 0;
        int n = nums.length;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
      //  int n = nums.length;
        for (int i = 0; i < 4; i++){
            min = Math.min(min, nums[n-4+i] - nums[i]);
        }
        return min;
    }
}
