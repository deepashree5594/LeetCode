class Solution {
    int resultBegin;
    int resultLength;
    
    public String longestPalindrome(String s) {
       if ( s.length() < 2)
          return s;
      for ( int start = 0; start < s.length(); start++)
      {
           expandRange(s, start, start);      // abcba
           expandRange(s, start, start+1);    // abba
      }
        
       return s.substring(resultBegin, resultBegin + resultLength);
     }
    
    public void expandRange(String s, int begin, int end)
    {
        while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end))
        {
            begin--;
            end++;            
        }       
        if ( resultLength < end - begin - 1)
        {
            resultBegin = begin + 1;
            resultLength = end - begin - 1;
        }
     }
}