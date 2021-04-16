// class Solution {
//     public int findLongestChain(int[][] pairs) {
//         if(pairs == null || pairs.length == 0)
//             return 0;
//         int n = pairs.length;
//         int[] dp = new int[n];
//         int maxLen = 0;
//         Arrays.fill(dp , 1);
//         for (int i = 1; i < n; i++){
//             for (int j = 0; j < i; j++){
//                 if (pairs[j][1] < pairs[i][0]){
//                     dp[i] = Math.max(dp[i], dp[j]+1);
//                     maxLen = Math.max(maxLen, dp[i]);
//                 }
//             }
//         }
//         return maxLen;
//     } 
// }

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int N = pairs.length;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for (int j = 1; j < N; ++j) {
            for (int i = 0; i < j; ++i) {
                if (pairs[i][1] < pairs[j][0])
                    dp[j] = Math.max(dp[j], dp[i] + 1);
            }
        }

        int ans = 0;
        for (int x: dp) if (x > ans) ans = x;
        return ans;
    }
}