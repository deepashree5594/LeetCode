class Solution {
    public boolean isValid(String s) {
      HashMap<Character, Character> map = new HashMap<Character, Character>();
      map.put(']', '[');
      map.put('}', '{');
      map.put(')', '(');
      Stack<Character> stack = new Stack<Character>();
      for ( char c : s.toCharArray())
      {
          if ( map.containsKey(c) && !stack.empty())
          {
              if (map.get(c) != stack.pop())
                  return false;
          }
          else
             stack.push(c);
      }
        return stack.isEmpty();
    }
}
