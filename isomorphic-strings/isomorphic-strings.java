class Solution {
//     public boolean isIsomorphic(String s, String t) {
        
//     }
//}
public boolean isIsomorphic(String s, String t) {

       if(s.length() != t.length())    return false;

       HashMap<Character, Character> map = new HashMap<>();

       HashSet<Character> set = new HashSet<>();

       for(int i=0; i<s.length(); i++)

       {

           char c = s.charAt(i);

           char d = t.charAt(i);

           if(!map.containsKey(c))

           {

               if (set.contains(d))

                   return false;

               map.put(c, d);

               set.add(d);

           }

           else

           {

               if(map.get(c) != d)

                   {
                   //set.add(d);

                   return false;}

           }

       }
    return true;

}
}