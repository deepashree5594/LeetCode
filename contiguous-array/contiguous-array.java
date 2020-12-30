// Time Complexity: O(n^2)
// Space Complexity: O(1)
// Did it run successfully on Leetcode? YES
class Solution {
    public int findMaxLength(int[] nums) {
       HashMap<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        int maxLen = 0;
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++)
        {
             if (nums[i] == 1){
                 runningSum = runningSum + 1;
             }
            else{
                runningSum = runningSum - 1;
            }
            if (map.containsKey(runningSum)) {          
                maxLen = Math.max(maxLen, (i-map.get(runningSum)));
            }
            else{
                map.put(runningSum, i);
            }
        }
        return maxLen;
    }
}
