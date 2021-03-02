// TC: O(3N), N-> length of T array
// SC: O(N)
// Did it run successfully on Leetcode? : Yes
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0)
             return new int[]{};
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < 2 * n ; i++)
        {
            while (!stack.isEmpty() && nums[i%n ] > nums[stack.peek()])
            {
                int index = stack.pop();
                result[index] = nums[i%n];
            }
            if ( i < n)
            {
                stack.push(i);
            }
        }
        return result;
    }
}