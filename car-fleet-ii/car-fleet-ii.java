class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        if ( cars == null || cars.length == 0)
            return new double[0];      
        int n = cars.length;
        double[] result = new double[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack();
        for (int i = n-1; i>=0; i--){
            // if the car ahead of me is slower, just pop it out of stack and check for remaining cars
            while (!stack.isEmpty() && cars[i][1] <= cars[stack.peek()][1]){
                stack.pop();
            }
            
            while (!stack.isEmpty()){
                double collisionTime = (double)(cars[stack.peek()][0] - cars[i][0])/ (cars[i][1] - cars[stack.peek()][1]);
                if (collisionTime <= result[stack.peek()] || result[stack.peek()] == -1){
                      result[i] = collisionTime;
                      break;
                }
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}