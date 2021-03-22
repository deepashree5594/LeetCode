//TC: O(N)
//SC: O(N)
//Did it run successfully on Leetcode? : Yes
class Solution {
    public int shortestSubarray(int[] A, int K) {
       int[] P = new int[A.length+1];
        for (int i = 0; i<A.length; i++)
        {
            P[i+1] = P[i] + A[i];
        }
        int minLen = P.length + 1;
        Deque<Integer> queue = new LinkedList();
        for (int y = 0; y < P.length; y++)
        {
            while (!queue.isEmpty() && P[y] <= P[queue.getLast()])
                queue.removeLast();
            while (!queue.isEmpty() && P[y] >= P[queue.getFirst()] + K)
                minLen = Math.min(minLen, y - queue.removeFirst());
            
            queue.addLast(y);
        }
        return minLen != P.length+1 ? minLen : -1; 
    }
}

//Better bruteforce
//TC: O(N*N)
//SC: O(N)
//Did it run successfully on Leetcode? : TLE
// class Solution {
//     public int shortestSubarray(int[] A, int K) {
//     int n = A.length;
//     if (n == 0)
//         return 0;
//     int ans = Integer.MAX_VALUE;
//     int[] sums = new int[n];
//     sums[0] = A[0];
//     for (int i = 1; i < n; i++)
//         sums[i] = sums[i - 1] + A[i];
//     for (int i = 0; i < n; i++) {
//         for (int j = i; j < n; j++) {
//             int sum = sums[j] - sums[i] + A[i];
//             if (sum >= K) {
//                 ans = Math.min(ans, (j - i + 1));
//                 break; //Found the smallest subarray with sum>=s starting with index i, hence move to next index
//             }
//         }
//     }
//     return (ans != Integer.MAX_VALUE) ? ans : -1;
//  }
// }