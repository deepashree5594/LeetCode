class Solution {
    HashMap<String, Integer> map;
    class comp implements Comparator<String>
    {
        public int compare(String word1, String word2)
        {
            int val = Integer.compare(map.get(word1), map.get(word2));
            if ( val == 0)
                return word2.compareTo(word1);
            return val;
        }
    };
    public List<String> topKFrequent(String[] words, int k) {
        map = new HashMap<String, Integer>();
       for (String word : words)
       {
           map.put(word, map.getOrDefault(word, 0) + 1);
       }     
      Queue<String> minHeap = new PriorityQueue<String>(new comp());
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