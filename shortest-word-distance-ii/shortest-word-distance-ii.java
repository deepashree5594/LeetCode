class WordDistance {
    HashMap<String, List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        map = new HashMap();
        for (int i = 0; i < wordsDict.length; i++){
            String word = wordsDict[i];
            if (!map.containsKey(word)){
                map.put(word, new ArrayList());
            }
            map.get(word).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> indexList1 = map.get(word1);
        List<Integer> indexList2 = map.get(word2);
        int i = 0;
        int j = 0;
        int minDistance = Integer.MAX_VALUE;
        while (i < indexList1.size() && j < indexList2.size()){
            int val1 = indexList1.get(i);
            int val2 = indexList2.get(j);
            minDistance = Math.min(minDistance, Math.abs(val1 - val2));
            if (val1 < val2){
                i++;
            }else{
                j++;
            }
        }
     return minDistance;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */