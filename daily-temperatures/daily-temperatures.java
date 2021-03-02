class Solution {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0)
            return new int[]{};
        Stack<Integer> stack = new Stack(); // put indices inside 
        int[] result = new int[T.length];
        for ( int i = 0; i < T.length; i++)
        {
            while (!stack.isEmpty() && T[i] > T[stack.peek()])
            {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
}