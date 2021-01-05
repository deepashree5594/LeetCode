class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int N = nums.length;
        HashSet<Integer> set = new HashSet<Integer>();
        List<Integer> result = new ArrayList();
        for (int num : nums)
        {
            set.add(num);
        }
        for (int i = 1; i <= N; i++)
        {
            if (!set.contains(i))
                result.add(i);
        }
        return result;
    }
}
