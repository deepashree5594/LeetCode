class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int n : nums)
        {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int count=0;
        for ( int i= 0; i < nums.length; i++)
        {
             int complement = k - nums[i];
             if (map.getOrDefault(nums[i], 0) > 0  && map.getOrDefault(complement, 0) > 0)
             {
                 if (nums[i] == complement && map.get(complement) < 2)
                          continue;
                 
                      map.put(nums[i], map.get(nums[i]) - 1);
                      map.put(complement, map.get(complement) - 1);
                     count++;    
              }
        }
        return count;
    }
}