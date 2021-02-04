class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if ( nums2 == null || nums2.length == 0)
            return new int[]{};
        HashMap<Integer, Integer> map = new HashMap();
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++)
            map.put(nums2[i], i);
        int j;
        for ( int i = 0; i < nums1.length; i++)
        {
            for ( j = map.get(nums1[i]) + 1; j < nums2.length; j++)
            {
                if ( nums1[i] < nums2[j] ) 
                {
                    res[i] = nums2[j];
                    break;
                }
            }
                if ( j == nums2.length )
                    res[i] = -1; 
            }

        return res;
    }
}
// public class Solution {
//     public int[] nextGreaterElement(int[] findNums, int[] nums) {
//         HashMap < Integer, Integer > hash = new HashMap < > ();
//         int[] res = new int[findNums.length];
//         int j;
//         for (int i = 0; i < nums.length; i++) {
//             hash.put(nums[i], i);
//         }
//         for (int i = 0; i < findNums.length; i++) {
//             for (j = hash.get(findNums[i]) + 1; j < nums.length; j++) {

//                 if (findNums[i] < nums[j]) {
//                     res[i] = nums[j];
//                     break;
//                 }
//             }
//             if (j == nums.length) {
//                 res[i] = -1;
//             }
//         }
//         return res;
//     }
// }