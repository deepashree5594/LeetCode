class Solution {
    public List<String> removeInvalidParentheses(String s) {
        // if ( s == null || s.length() == 0)
            // return new ArrayList();
        Queue<String> q = new LinkedList();
        HashSet<String> set = new HashSet();
        List<String> result = new ArrayList();
        q.add(s);
        set.add(s);
        boolean flag = false;
        while (!q.isEmpty())
        {
            String curr = q.poll();
            StringBuilder sb;
            if (isValid(curr))
            {
               flag = true;
               result.add(curr);
            }  
             if (!flag)    // if we did not find the valid string till now then add its babies to the queue
             {
                for ( int i = 0; i < curr.length(); i++)
                {
                  if (Character.isLetter(curr.charAt(i)))
                      continue;
                    
                  sb = new StringBuilder();
                  sb.append(curr.substring(0, i)).append(curr.substring(i+1));
                  String baby = sb.toString();
                  if (!set.contains(baby))
                   {
                        
                         q.add(baby);
                         set.add(baby);
                   }
                 }
               }
            } 
        
        return result;
    }
    private boolean isValid(String s)
    {
        int openCount = 0;
        for (char c: s.toCharArray())
        { 
            if ( c == '(')
                openCount++;
            else if (c == ')')  
            {
                if(openCount == 0)
                  return false;
                openCount--;
            } 
        }
        return openCount == 0;
    }
}