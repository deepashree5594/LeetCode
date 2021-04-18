class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxNum = Integer.MIN_VALUE;
        for ( int num : nums){
            maxNum = Math.max(maxNum, num);
        }
        int[] countsArray = new int[maxNum+1];
        // fill in the countsArray
        for (int i = 0; i < nums.length; i++){
            countsArray[nums[i]] =  countsArray[nums[i]] + nums[i];
        }
        int skip = 0;
        int use = countsArray[0];
        for ( int i = 1; i < countsArray.length; i++){
            int temp = skip;
            skip = Math.max(skip, use);
            use = temp + countsArray[i];
        }
        return Math.max(use, skip);
    }
}