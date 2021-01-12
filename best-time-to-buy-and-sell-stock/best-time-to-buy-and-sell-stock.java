// maxProfit is the difference between min element and max element that comes after it
class Solution {
    public int maxProfit(int[] prices) {
      int maxProfit = 0;
      int min = Integer.MAX_VALUE;
      for ( int i = 0; i < prices.length; i++)
      {
         min = Math.min(min,prices[i]);
         maxProfit = Math.max(maxProfit, prices[i] - min);             
      }
        return maxProfit;
    }
}
​
