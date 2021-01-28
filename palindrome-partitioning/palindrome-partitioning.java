class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList();
        if ( s == null || s.length() == 0)
            return result;
        helper(s, 0, new ArrayList());
        return result;
    }
    private void helper(String s, int pivotIndex, List<String> path)
    {
        if ( pivotIndex == s.length())
        {
            result.add(new ArrayList(path));
            return;
        } 
    
       for (int i = pivotIndex; i < s.length(); i++)
       {
           if (isPalindrome( s, pivotIndex, i))
           {
                 //action
                path.add(s.substring(pivotIndex, i+1));
                // recurse
                helper( s, i+1, path);
                 // backtrack
                path.remove(path.size()-1);
            }       
         }
    }
    private boolean isPalindrome(String str, int l, int r)
    {
        // int l = 0;
        // int r = str.length() -1;
        while ( l <= r)
        {
            if (str.charAt(l) != str.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}