class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if (logs == null || logs.size() == 0)
            return new int[0];
        int[] result = new int[n];
        int prev = 0;
        int curr = 0;
        Stack<Integer> stack = new Stack();
        for (String log : logs){
            String[] record = log.split(":");
            if (record[1].equals("start")){
                if (!stack.isEmpty()){
                    curr = Integer.parseInt(record[2]);
                    result[stack.peek()] =  result[stack.peek()] + (curr - prev);
                    prev = curr;
                }
                stack.push(Integer.parseInt(record[0]));
            } else {
                curr = Integer.parseInt(record[2]);
                result[stack.peek()] = result[stack.peek()] + (curr - prev + 1);
                prev = curr+1;
                stack.pop();
            }
        }
        return result;
    }
}