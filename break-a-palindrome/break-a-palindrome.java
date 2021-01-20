class Solution {
    public String breakPalindrome(String palindrome) {
        if ( palindrome == null || palindrome.length() == 0)
              return "";
        int n = palindrome.length();
        char[] palindromeArr = palindrome.toCharArray();
         
        for ( int i = 0; i < n/2; i++)
        {
            if (palindromeArr[i] != 'a')
            {
                palindromeArr[i] = 'a';
                return new String(palindromeArr);
            }
        }
        // if all a's
        palindromeArr[n-1] = 'b';
        if (n < 2)
            return "";
        return new String(palindromeArr);
    }
}
