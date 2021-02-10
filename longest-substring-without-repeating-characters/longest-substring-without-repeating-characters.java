// TC: O(2n) - O(n)-  Sliding window
// SC: O(M) -> M - length of Substring Without Repeating Characters
// Did it run successfully on Leetcode? : Yes
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int i = 0;
//         int j = 0;
//         int ans = 0;
//         HashSet<Character> set = new HashSet<Character>();
//         while ( j < s.length())
//         {
//             if (set.contains(s.charAt(j)))
//             {
//                 set.remove(s.charAt(i));
//                 i++;
//             }
//             else
//             {
//                 set.add(s.charAt(j));
//                 j++;
//                 ans = Math.max(ans, j - i);
//             }    
//         }
//       return ans;
//     }
// }



//Using HashMap
// TC : O(n) 
// SC : O(1)   -> only lower case letters
// Did it run successfully on Leetcode? : Yes
 class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int slow = 0;
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (map.containsKey(c))
            {
                slow = Math.max(slow, map.get(c));
            }
            max = Math.max(max, i - slow + 1);
            map.put(c, i+1);
        }
      return max;
    }
}

