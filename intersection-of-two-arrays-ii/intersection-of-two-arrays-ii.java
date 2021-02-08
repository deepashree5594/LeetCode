
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       int n1 = nums1.length;
       int n2 = nums2.length;
       if ( n1 > n2)
         return intersect(nums2, nums1);
       HashMap<Integer, Integer> map = new HashMap();
       List<Integer> list = new ArrayList();
       for ( int num : nums1)
       {
           map.put(num, map.getOrDefault(num, 0) + 1);
       }
        
       for ( int num : nums2)
       {
           if (map.containsKey(num))
           {
               map.put(num, map.get(num) - 1);
               map.remove(num, 0);
               list.add(num);
           }
       }
       int[] result = new int[list.size()];
       for ( int i = 0; i < result.length; i++)
       {
           result[i] = list.get(i);
       }
        return result;
  }
}


      
// class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {
       
//     }
// }
