class Solution {
    HashMap<Character, HashSet<Character>> adjList;
    int[] inDegree;
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0)
            return "";
        inDegree = new int[26];
        adjList = new HashMap();
        buildGraph(words);
        Queue<Character> q = new LinkedList();
        //check for indepenedent nodes and add them to queue
        for (char c : adjList.keySet()){
            if (inDegree[c - 'a'] == 0)
                q.offer(c);
        }
        //BFS
        StringBuilder result = new StringBuilder();
        while (!q.isEmpty()){
            char curr = q.poll();
            result.append(curr);
            for (char depenedent : adjList.get(curr)){
                inDegree[depenedent - 'a']--;
                if (inDegree[depenedent - 'a'] == 0){
                    q.offer(depenedent);
                }
            }   
        }
        if ( result.length() != adjList.size()){
            return "";
        }
        return result.toString();
   }
    private void buildGraph(String[] words){
        for (String word: words){
            for (int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if (!adjList.containsKey(c))
                   adjList.put(c, new HashSet());
            }
        }
        for (int i = 0; i < words.length - 1; i++){
            String first = words[i];
            String second = words[i+1];
            int m = first.length();
            int n = second.length();
            if ((first).startsWith(second) && m > n){
                adjList.clear();
            } 
            for (int j = 0; j < m && j < n; j++){
                char out = first.charAt(j);
                char in = second.charAt(j);
                if (in != out){
                    if (!adjList.get(out).contains(in)){
                        adjList.get(out).add(in);
                        inDegree[in - 'a']++; 
                 }
                     break; 
                }
                
            }
            
        }
    }
}


