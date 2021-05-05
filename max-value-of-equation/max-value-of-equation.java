//(yi - xi)  + (xj + yj)
class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        if (points == null || points.length == 0)
            return 0;
        int result = Integer.MIN_VALUE;
        Deque<Pair<Integer, Integer>> dq = new ArrayDeque<>();
        for (int[] p : points){
          while (!dq.isEmpty() && p[0] - dq.peekFirst().getValue() > k){
             dq.pollFirst();
          }
          if (!dq.isEmpty()){
              result = Math.max(result, p[0] + p[1] + dq.peekFirst().getKey());
          }
          while (!dq.isEmpty() && (p[1] - p[0] > dq.peekLast().getKey())){
             dq.pollLast();
          } 
          dq.offerLast(new Pair<>((p[1] - p[0]), p[0]));  
        }
       return result;
    }
}
 // public int findMaxValueOfEquation(int[][] points, int k) {
 //        Deque<Pair<Integer, Integer>> ms = new ArrayDeque<>();
 //        int res = Integer.MIN_VALUE;
 //        for (int[] point : points) {
 //            while (!ms.isEmpty() && point[0] - ms.peekFirst().getValue() > k) {
 //                ms.pollFirst();
 //            }
 //            if (!ms.isEmpty()) {
 //                res = Math.max(res, ms.peekFirst().getKey() + point[0] + point[1]);
 //            }
 //            while (!ms.isEmpty() && point[1] - point[0] > ms.peekLast().getKey()) {
 //                ms.pollLast();
 //            }
 //            ms.offerLast(new Pair<>(point[1] - point[0], point[0]));
 //        }
 //        return res;
 //    }