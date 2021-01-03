​
class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> pMap = new HashMap<Character, String>();
        HashMap<String, Character> sMap = new HashMap<String, Character>();
        String[] strs = s.split(" ");
        if (pattern.length() != strs.length)
               return false;
        int i = 0; 
        int j = 0;
        while ( i<pattern.length() && j < strs.length )
        {
            String word = strs[j];
            char c = pattern.charAt(i);
            
            if (!pMap.containsKey(c))
            {
                pMap.put(c, word);
            }
            else
            {
                if (!pMap.get(c).equals(word))
                    return false;
            }
            if (!sMap.containsKey(word))
            {
                sMap.put(word, c);
            }
            else
            {
                if (sMap.get(word) != c)
                    return false;
            }
            i++;
            j++;
        }
        return true;
    }    
}
​
​
​
​
