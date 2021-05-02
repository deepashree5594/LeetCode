class Solution {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0)
            return new int[0];
        Stack<Integer> stack = new Stack();
        int n = T.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++){
            while (!stack.isEmpty() && T[i] > T[stack.peek()]){
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
}