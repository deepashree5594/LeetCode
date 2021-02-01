// Time Complexity  O(N+M).
// Space Complexity  O(N+M).
// We traverse each character in the input string once and only once. At each iteration, it takes constant time to perform the operations, except the operation that we build a new string out of the buffer. Excluding the cost of string-building out of the iteration, we can consider the cost of iterations as \mathcal{O}(N)O(N).

// If we combine all the string-building operations all together, in total it would take another \mathcal{O}(N)O(N) time.

// In addition, we built a set out of the list of banned words, which would take \mathcal{O}(M)O(M) time.

// Hence, the overall time complexity of the algorithm is \mathcal{O}(N) + \mathcal{O}(N) + \mathcal{O}(M) = \mathcal{O}(N + M)O(N)+O(N)+O(M)=O(N+M).

// Space Complexity: \mathcal{O}(N + M)O(N+M).

// We built a hashmap to count the frequency of each unique word, whose space would be of \mathcal{O}(N)O(N).

// Similarly, we built a set out of the banned word list, which would consume additional \mathcal{O}(M)O(M) space.

// Therefore, the overall space complexity of the algorithm is \mathcal{O}(N + M)O(N+M).


class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
      if ( paragraph == null || paragraph.length() == 0)
          return "";
        
      Set<String> bannedSet = new HashSet();
      for (String word : banned)
          bannedSet.add(word);
        
      HashMap<String, Integer> map = new HashMap();
      char[] charArray = paragraph.toCharArray();
      StringBuilder sb = new StringBuilder();
      int maxCount = 0;
      String maxWord = ""; 
      for (int i = 0; i < charArray.length; i++)
      {
          char c = charArray[i];
          if (Character.isLetter(c))
          {
              sb.append(Character.toLowerCase(c));
              if (i != charArray.length -1 )
                  continue;
          }
          if ( sb.length() > 0)
          {
              String word = sb.toString();
              if (!bannedSet.contains(word))
              {
                 map.put(word, map.getOrDefault(word, 0) + 1);
                 if (map.get(word) > maxCount)
                 {
                  maxCount = map.get(word);
                  maxWord = word;
                 }
               }
              sb.setLength(0);
          }
      }
        return maxWord;
    }
}