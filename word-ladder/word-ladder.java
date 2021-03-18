class Solution {
    class Pair{
        String str;
        int level;
        Pair(String s, int level)
        {
            this.str = s;
            this.level = level;
        }      
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       // if (beginWord == null || beginWord.length() == 0 || beginWord.equals(endWord))
       //       return 0;
       HashMap<String, List<String>> map = new HashMap();
       HashSet<String> set = new HashSet();
       for (String word: wordList)
       {
           String s = null;
           for ( int i = 0; i < word.length(); i++)
           {
               StringBuilder sb = new StringBuilder();
               sb.append(word.substring(0,i)).append("*").append(word.substring(i+1));
               s = sb.toString(); 
               System.out.println("Pattern " + i + " " + s);
         
               if (!map.containsKey(s))
               {
                  map.put(s, new ArrayList());
               }
               
              map.get(s).add(word);
           }
       }
       
       //BFS
       Queue<Pair> q = new LinkedList();
       q.offer(new Pair(beginWord, 1));
       set.add(beginWord);
       while(!q.isEmpty()) 
       {
           Pair curr = q.poll();
           String currWord = curr.str;
           int currLevel = curr.level;
           StringBuilder sb = null;
           for ( int i = 0; i < currWord.length(); i++)
           {
               sb = new StringBuilder();
               sb.append(currWord.substring(0,i)).append("*").append(currWord.substring(i+1));
               String nextPattern = sb.toString();
               if ( map.containsKey(nextPattern) && map.get(nextPattern) != null)
               {
                  List<String> nextWords =  map.get(nextPattern);
                  for ( String nextWord: nextWords)
                  {
                    if (nextWord.equals(endWord))
                       return currLevel+1;
                   
                    if (!set.contains(nextWord))
                    {
                       set.add(nextWord);
                       q.add(new Pair(nextWord, currLevel+1));
                    }
                   }
                }
           }
       }
   return 0;
    }
}