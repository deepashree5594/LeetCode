// class Solution {
//     public boolean wordPattern(String pattern, String s) {
//         HashMap map = new HashMap();
//         String[] strs = s.split(" ");
//         if (pattern.length() != strs.length)
//                return false;
        
//         for (int i = 0; i < strs.length; i++ )
//         {
//             char c = pattern.charAt(i);
//             String word = strs[i];
            
//             if (!map.containsKey(c))
//             {
//                 map.put(c, i);
//             }
//             if (!map.containsKey(word))
//             {
//                 map.put(word, i);
//             }
//             if (map.get(c) != map.get(word))
//                 return false;
//         }
//         return true;
//     }
// }
​
class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap map_index = new HashMap();
        String[] words = s.split(" ");
​
        if (words.length != pattern.length())
            return false;
​
        for (Integer i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String w = words[i];
​
            if (!map_index.containsKey(c))
                map_index.put(c, i);
​
            if (!map_index.containsKey(w))
                map_index.put(w, i);
​
            if (map_index.get(c) != map_index.get(w))
                return false;
        }
​
        return true;
    }
}
