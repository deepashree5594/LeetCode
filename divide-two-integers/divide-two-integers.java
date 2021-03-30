
class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MAX_VALUE && divisor == 0)
            return Integer.MAX_VALUE;
         if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
         long ldividend = Math.abs((long)(dividend));
         long ldivisor = Math.abs((long)(divisor));
        int result = 0;
         while (ldividend >= ldivisor){
             int numShits = 0;
             while (ldividend >= (ldivisor << numShits)){
                 numShits++;
             }
             numShits--;
             ldividend = ldividend - (ldivisor << numShits);
             result = result + (1<<numShits);
         }
        if (dividend < 0 && divisor < 0) return result;
        if (dividend > 0 && divisor > 0) return result;
        return -result;
    }
}