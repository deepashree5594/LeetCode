class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        buy[0] = -prices[0];
        buy[1] = Math.max(buy[0], 0 - prices[1]);
        sell[1] = Math.max(sell[0], buy[0] + prices[1]);
        for (int i = 2; i < prices.length; i++){
            buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
        }
        return sell[n-1];
    }
}
// class Solution {
//     public int maxProfit(int[] prices) {
//         if (prices == null || prices.length == 0)
//             return 0;
//         return helper(prices, 0, -1, 0);
//     }
//     private int helper(int[] prices, int index, int prevBuy, int profit){
//         //base
//         if (index >= prices.length){
//             return profit;
//         } 
//         //logic
//         if (prevBuy == -1){  //buy state
//             //2 casses
//             //choose
//             int case1 = helper(prices, index+1, prices[index], profit);
//             //dont choose
//             int case2 = helper(prices, index+1, -1, profit);
//             return Math.max(case1, case2);
//         } else { //sell
//             //choose
//             int case3 = helper(prices, index+2, -1, profit+(prices[index] - prevBuy));
//             //dont choose
//             int case4 = helper(prices, index+1, prevBuy, profit);
//             return Math.max(case3, case4);
            
//         }
//     }
// }