class Solution {
    public int findMaxLength(int[] nums) {
        if ( nums == null || nums.length == 0)
             return 0;
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        int maxLen = 0;
        int runningSum = 0;
        for(int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                runningSum = runningSum + 1;
            } else {
                runningSum = runningSum - 1;
            }
            if (map.containsKey(runningSum)){
                maxLen = Math.max(maxLen, i - map.get(runningSum));
            } else{
                 map.put(runningSum, i);
            }
        }
    return maxLen;
    }
}