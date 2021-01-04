// class Solution {
//     public int fib(int N) {
//         if (N == 1 || N == 0)
//           return N;
//         return fib(N-1) + fib(N-2);
//     }
// }
​
class Solution{
    public int fib(int N)
    {
        if (N == 0) 
            return 0;
        if (N == 1)
            return 1;
        int[] dp = new int[N];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++)
        {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[dp.length-1];
    }
}
​
// class Solution {
//     public int fib(int N) {
//         double goldenRatio = (1 + Math.sqrt(5)) / 2;
//         return (int)Math.round(Math.pow(goldenRatio, N)/ Math.sqrt(5));
//     }
// }
​
​
// class Solution {
//     public int fib(int N) {
//        if (N <=1 )
//           return N;
//         if (N == 2)
//           return 1;
//         int current = 0;
//         int prev1 = 1;
//         int prev2 = 1;
//         for ( int i = 3; i <= N ; i++)
//         {
//             current = prev1 + prev2;
//             prev2 = prev1;
//             prev1 = current;
//         }
//         return current;
//     }
// }
​
​
