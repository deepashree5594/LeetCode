class Solution {
    public int longestPalindrome(String s) {
       int[] charCount = new int[128];   
        int result = 0;
       for (char c: s.toCharArray())
       {
           if (++charCount[c] == 2)
           {
               result = result + 2;
               charCount[c] = 0;
           }
       }
      
       return result == s.length() ? result : result + 1;
    }
}
