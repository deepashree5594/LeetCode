class Solution {
    public List<String> topKFrequent(String[] words, int k) {
       HashMap<String, Integer> map = new HashMap<String, Integer>();
       for (String word : words)
       {
           map.put(word, map.getOrDefault(word, 0) + 1);
       }
        
      Queue<String> minHeap = new PriorityQueue<String>(
      (word1, word2) -> map.get(word1).equals(map.get(word2))? word2.compareTo(word1) : map.get(word1) - map.get(word2));
        
         
        
        for (String word: map.keySet())
        {
            minHeap.add(word);
            if (minHeap.size() > k)
                minHeap.poll();
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k ; i++)
        {
            result.add(minHeap.poll());
        }
        Collections.reverse(result);
        return result;
    }
}
