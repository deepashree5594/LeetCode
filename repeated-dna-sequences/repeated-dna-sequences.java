class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        HashMap<String, Integer> map = new HashMap();
       // HashSet<String> set = new HashSet();
         List<String> set = new ArrayList();
        for (int i = 0; i < s.length() - 10 + 1; i++){
           String sequence = s.substring(i, i+10);
           if (!map.containsKey(sequence)){
               map.put(sequence, 1);
           }else{
                int count = map.get(sequence);
                map.put(sequence, count+1);
                if (count+1 == 2)
                    set.add(sequence);
               }
          }
        return set;
    }
}
//012345678910
//AAAAAAAAAAA