class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList();
        if (p == null || p.length() == 0)
            return result;
        HashMap<Character, Integer> map = new HashMap();
        int match = 0;
        for (char c : p.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for ( int i = 0; i < s.length(); i++){
            //incoming char
            char incomingChar = s.charAt(i);
            if (map.containsKey(incomingChar)){
                int count = map.get(incomingChar);
                count--;
                if(count == 0){
                    match++;
                }
                map.put(incomingChar, count);
            }
           if (i >= p.length()){
             char outgoingChar = s.charAt(i-p.length());
                if (map.containsKey(outgoingChar)){
                    int count = map.get(outgoingChar);
                    count++;
                    if(count == 1){
                     match--;
                     }
                    map.put(outgoingChar, count);
                    }
           }
            if ( match == map.size()){
                result.add( i - p.length() + 1);
            }
        }
        return result;
    }
}