//O(NK)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // List<List<String>> list = new ArrayList();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        int[] charCountArr;
        StringBuilder sb;
        for ( String str : strs)
        {     
            charCountArr = new int[26];
            
            for ( int i = 0; i < str.length(); i++)
            {               
                charCountArr[str.charAt(i) - 'a']++;
            }
            sb = new StringBuilder();
            for ( int i = 0; i < 26; i++)
            {
                sb.append(charCountArr[i]).append('#');
            }
            String s = sb.toString();
            if  (!map.containsKey(s))        
            {
                map.put(s, new ArrayList());
            }
            map.get(s).add(str);
            
        }
        return new ArrayList(map.values());
        
    }
}
​
// O(NKlogK)
// class Solution {
//      public List<List<String>> groupAnagrams(String[] strs) {
//          if ( strs.length == 0) return new ArrayList();
//          Map<String, List> map = new HashMap<String, List>();
//          for ( String s : strs)
//          {
//              char[] charArray = s.toCharArray();
//              Arrays.sort(charArray);
//              String key = String.valueOf(charArray);
//              if (!map.containsKey(key))
//              {
//                  map.put(key, new ArrayList());
//              }
//              map.get(key).add(s);
//          }
//          return new ArrayList(map.values());         
//      }
// }
