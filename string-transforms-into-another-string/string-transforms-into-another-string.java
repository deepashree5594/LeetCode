class Solution {
    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2))
            return true;
        if (str1.length() != str2.length())
            return false;
        HashMap<Character, Character> adjList = new HashMap();
        HashMap<Character, Integer> outDegree = new HashMap();
        for(int i = 0; i < str1.length(); i++)
        {
            char c1 = str1.charAt(i); 
            char c2 = str2.charAt(i); 
            if (adjList.containsKey(c1))
            {
                if(adjList.get(c1) != c2)
                    return false;
                 
            }            
            // else
            // {
                   adjList.put(c1, c2);    
           // }
        }
        HashSet<Character> set = new HashSet(adjList.values());
        return set.size() < 26;
    }
}

//str1 = aabcc
//str2 = ccdee  - destination

//leetcode 
//codeleet



// public boolean canConvert(String s1, String s2) {
//         if (s1.equals(s2)) return true;
//         Map<Character, Character> arr = new HashMap<>();
//         for (int i = 0; i < s1.length(); ++i) {
//             if (arr.getOrDefault(s1.charAt(i), s2.charAt(i)) != s2.charAt(i))
//                 return false;
//             arr.put(s1.charAt(i), s2.charAt(i));
//         }
//         return new HashSet<Character>(arr.values()).size() < 26;
//     }


// "aabcc"    map(a:c)
// "ccdee"

