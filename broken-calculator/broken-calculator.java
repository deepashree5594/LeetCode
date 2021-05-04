//Greedy
//TC: O(logY)
//SC: O(1)
//Did it run successfully on Leetcode?:Yes
class Solution {
    public int brokenCalc(int X, int Y) {
        if (X == Y)
          return 0;
        int count = 0;
        while ( Y > X ){
            if (Y % 2  == 0){
                Y = Y/2;
            }
            else {
                Y = Y + 1;
            }
            count++;
        }
        count = count + Math.abs(Y - X);
        return count;
    }
}

//BFS
//TC: O(exponential)
//SC: O(N) - N is very large, for every intermediate number, we add 2 possible values
//Did it run successfully on Leetcode?:TLE
// class Solution {
//     public int brokenCalc(int X, int Y) {
//         if (X == Y)
//             return 0;
//         Queue<Integer> q = new LinkedList();
//         q.add(X);
//         int steps = 0;
//         while(!q.isEmpty()){
//             int size = q.size();
//             for (int i = 0; i < size; i++){
//                 int curr = q.poll();
//                 if ( curr == Y)
//                     return steps;
//                 if (curr > Y) {
//                     q.offer(curr-1);
//                 } 
//                 else{
//                      q.offer(curr-1);
//                      q.offer(curr * 2);
//                 } 
//             }
//             steps++;
//         }
//         return Integer.MAX_VALUE;
//     }
// }