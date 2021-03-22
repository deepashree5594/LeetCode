class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if ( nums == null || nums.length == 0)
            return 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int runningSum = 0;
        for (int end = 0; end < nums.length; end++) {
             if (nums[end] == target)  
                 return 1;
             runningSum += nums[end];
            if (runningSum >= target)
            {
                minLen = Math.min(minLen, end - start+1);
                while (start < nums.length && runningSum >= target)
                {
                    minLen = Math.min(minLen, end - start+1);
                    runningSum -= nums[start++];
                }
            }
        }
        if (minLen == Integer.MAX_VALUE)
            return 0;
        return minLen;
    }
}