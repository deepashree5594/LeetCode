//             if  (!map.containsKey(s))        
//             {
//                 map.put(s, new ArrayList());
//             }
//             map.get(s).add(str);
            
//         }
//         return new ArrayList(map.values());
        
//     }
// }
​
​
//TC: O(NK)
//SC: O(NK) - N is no. of the sorted strings (key) and K is the avg length of arraylist which holds the answer ( groups anagrams)
class Solution {
     public List<List<String>> groupAnagrams(String[] strs) {
         if ( strs.length == 0) 
           return new ArrayList();
         Map<Long, List> map = new HashMap<Long, List>();
         for ( String s : strs)
         {
             long primeNumber = getPrimeFactor(s);
             if (!map.containsKey(primeNumber))
             {
                 map.put(primeNumber, new ArrayList());
             }
             map.get(primeNumber).add(s);
         }
         return new ArrayList(map.values());         
     }
    private long getPrimeFactor(String s)
    {
        int[] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,93,97,101,103};
        long result = 1;
        for (int i = 0; i < s.length(); i++)
        {
            result *= s.charAt(i) * primes[s.charAt(i) - 'a'];
        }
        return result;
    }
}
​
​
//TC: O(NKlogK)
//SC: O(NK) - N is no. of the sorted strings (key) and K is the avg length of arraylist which holds the answer ( groups anagrams)
// class Solution {
//      public List<List<String>> groupAnagrams(String[] strs) {
//          if ( strs.length == 0) return new ArrayList();
//          Map<String, List> map = new HashMap<String, List>();
//          for ( String s : strs)
//          {
//              char[] charArray = s.toCharArray();
//              Arrays.sort(charArray);
//              String key = String.valueOf(charArray);
