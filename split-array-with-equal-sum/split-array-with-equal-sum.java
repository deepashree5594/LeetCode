//TC: O(N^2)
//SC: O(N)
//Did it run suucessfully on Leetcode?:Yes
class Solution {
    public boolean splitArray(int[] nums) {
        if ( nums == null || nums.length == 0)
            return false;
        int n = nums.length;
        if ( n< 7)
            return false;
        int[] sum = new int[n];
        sum[0] = nums[0];

        for ( int i = 1; i < sum.length; i++){
            sum[i] = sum[i-1] + nums[i];
        }
        
        for (int j = 3; j < n - 3; j++){
            HashSet<Integer> set = new HashSet();
            for (int i = 1; i < j -1 ; i++){
                if ( sum[i-1]  == sum[j-1] - sum[i])
                    set.add(sum[i-1]);
            }
            for (int k = j+2; k < n-1; k++){
                if (sum[n-1] - sum[k] == sum[k-1] - sum[j] && set.contains(sum[n-1] - sum[k])){
                    return true;
                }
            }
        }
        return false;
    }
    
}

// sum(0, i - 1) = sum(0, 0) = 1
// sum(i + 1, j - 1) = sum(2, 2) = 1
// sum(j + 1, k - 1) = sum(4, 4) = 1
// sum(k + 1, n - 1)

//TLE
//TC: O(N^3)
//SC: O(1)
// class Solution {
//     public boolean splitArray(int[] nums) {
//         if ( nums == null || nums.length == 0)
//             return false;
//         if ( nums.length < 4)
//             return false;
//         for ( int i = 0; i < nums.length - 4; i++){
//             for ( int j = i+2; j < nums.length - 2; j++){
//                 for (int k = j+2; k < nums.length; k++){
//                     if (getSum(0, i-1, nums) == getSum(i+1, j-1, nums) 
//                         && getSum(i+1, j-1, nums) == getSum(j + 1, k - 1, nums) 
//                         && getSum(j + 1, k - 1, nums) == getSum(k + 1, nums.length - 1, nums))
//                         return true;
//                 }
//             }
//         }
//         return false;
//     }
//     private int getSum(int start, int end, int[] nums){
//         int sum = 0;
//         for ( int i = start; i <= end; i++ ){
//             sum += nums[i];
//         }
//         return sum;
//     }
// }