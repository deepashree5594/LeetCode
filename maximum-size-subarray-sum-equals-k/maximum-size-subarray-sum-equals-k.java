class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0,-1);
        int runningSum = 0;
        int result = 0;
        for (int i = 0; i < nums.length ; i++)
        {
            runningSum = runningSum  + nums[i];
            int complement = runningSum - k;
            if (map.containsKey(complement))
            {
                result = Math.max(result, i - map.get(complement));
            }
            if (!map.containsKey(runningSum))
                map.put(runningSum, i);
            
        }
        return result;
    }
}

