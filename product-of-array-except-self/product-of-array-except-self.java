// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int[] leftarray = new int[nums.length];
//         int[] rightarray = new int[nums.length];
//         int[] result = new int[nums.length];
        
//         leftarray[0] = 1;
//         for ( int i = 1; i < leftarray.length; i++)
//         {
//             leftarray[i] = leftarray[i-1] * nums[i-1];
//         }
        
//         rightarray[rightarray.length-1] = 1;
//         for ( int i = rightarray.length-2; i >=0; i--)
//         {
//             rightarray[i] = rightarray[i+1] * nums[i+1];
//         }
        
//         for ( int i = 0; i < result.length; i++)
//         {
//             result[i] = leftarray[i] * rightarray[i];
//         }
        
//         return result;
//     }
// }


//https://www.youtube.com/watch?v=tSRFtR3pv74&ab_channel=NickWhite

// TC: O(2N) = O(N) -  N is the no. of elements of nums array
// SC: O(1) - No extra space required
// Did it run successfully on Leetcode? : Yes
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if ( nums == null || nums.length == 0)
            return new int[]{};
        
        int[] result = new int[nums.length];
        result[0] = 1;
        for ( int i = 1; i < result.length; i++)
        {
            result[i] = result[i-1] * nums[i-1];
        }
        int runningProduct = 1;
        for (int i = result.length-1; i>= 0; i--)
        {
            result[i] = result[i] * runningProduct;
            runningProduct = runningProduct * nums[i];
        }
        return result;
    }
}
        
        
        
//        int[] result = new int[nums.length];
        
//        if ( nums == null || nums.length == 0)
//            return result;
//         result[0] = 1;
//         for ( int i = 1; i < nums.length; i++)
//         {
//            result[i] = result[i-1] * nums[i-1];
//         }  
//         int runningProduct = 1;
//         for ( int i = nums.length-1; i>=0; i--)
//         {
//             result[i] = runningProduct * result[i] ;
//             runningProduct = runningProduct * nums[i];
//         }
//         return result;
//     }
    
// }