// https://www.youtube.com/watch?v=-3Lt-EwR_Hw&ab_channel=GauravSen
//TC: O(logN)
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if ( n < 0)
        {
            x = 1/x;
            N = -N;
        }
        double ans = 1;
        double currentProduct = x;
        for ( long i = N; i  > 0; i = i/2)
        {
            if ((i%2) == 1)
            {
                ans = ans * currentProduct;
            }
            currentProduct = currentProduct * currentProduct;
        }
   return ans;   
    }
}
​
// TC: O(N)
// class Solution {
//     public double myPow(double x, int n) {
//         long N = n;
//         if ( n < 0)
//         {
//             x = 1/x;
//             N = -N;
//         }
//         double ans = 1;
//         for ( int i = 1; i <= N; i++)
//         {          
//               ans = ans * x;         
//         }
//         return ans;
//     }
// }
