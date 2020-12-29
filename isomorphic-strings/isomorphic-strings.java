// Time Complexity: O(N) - length of s and t strings
// Space Complexity: O(K) - K is constant (128)
// Did it run sucessfully on Leetcode? Yes
class Solution {
//     public boolean isIsomorphic(String s, String t) {
​
      
        
//      int[] arr1 = new int[128];
//      int[] arr2 = new int[128];
        
//      for (int i = 0; i < s.length(); i++)
//      {
//          if (arr1[s.charAt(i) ] != arr2[t.charAt(i) ] )
//              return false;
//          arr1[s.charAt(i) ] = i+1;
//          arr2[t.charAt(i) ] = i+1;
//      }
//         return true;
    
//     }
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Character> sMap = new HashMap<Character, Character>();
        HashMap<Character, Character> tMap = new HashMap<Character, Character>();
        int i = 0; 
        int j = 0;
        while ( i < s.length() && j < t.length())
        {
            char sChar = s.charAt(i);
            char tChar = t.charAt(j);
            if (sMap.containsKey(sChar))
            {
                if (sMap.get(sChar) != tChar)
                    return false;
            }
            else
            {
                sMap.put(sChar, tChar);
            }
            if (tMap.containsKey(tChar))
            {
                if (tMap.get(tChar) != sChar)
                    return false;
            }
            else
            {
                tMap.put(tChar, sChar);
            }
            i++;
            j++;
        }
        return true;
    }
}
