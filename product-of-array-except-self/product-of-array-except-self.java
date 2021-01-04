// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int[] leftarray = new int[nums.length];
//         int[] rightarray = new int[nums.length];
//         int[] result = new int[nums.length];
        
//         leftarray[0] = 1;
//         for ( int i = 1; i < leftarray.length; i++)
//         {
//             leftarray[i] = leftarray[i-1] * nums[i-1];
//         }
        
//         rightarray[rightarray.length-1] = 1;
//         for ( int i = rightarray.length-2; i >=0; i--)
//         {
//             rightarray[i] = rightarray[i+1] * nums[i+1];
//         }
        
//         for ( int i = 0; i < result.length; i++)
//         {
//             result[i] = leftarray[i] * rightarray[i];
//         }
        
//         return result;
//     }
// }
​
​
//https://www.youtube.com/watch?v=tSRFtR3pv74&ab_channel=NickWhite
​
class Solution {
    public int[] productExceptSelf(int[] nums) {
       int[] result = new int[nums.length];
        
       if ( nums == null || nums.length == 0)
           return result;
        
        int[] left = new int[nums.length];
        int right = 1;
        
        left[0] = 1;
        for ( int i = 1; i < nums.length; i++)
        {
            left[i] = left[i-1] * nums[i-1];
        }
        
        for ( int i = result.length-1 ; i >= 0; i--)
        {
            result[i] = left[i] * right;
            right = right * nums[i];
        }
        
        return result;
    }
    
}
