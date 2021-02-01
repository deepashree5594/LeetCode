class Solution {
    int count;
    int num;
    public int countArrangement(int n) {
        if ( n == 0)
            return 0;
        num = n;
        boolean[] visited = new boolean[n+1];
        helper(n, 1, visited);
        return count;
    }
    private void helper(int num, int index, boolean[] visited)
    {
        //base
        if (index > num)
        {
            count++;
        }
        
        //logic
        for ( int i = 1; i <= num; i++)
        {
            if (!visited[i] && isBeautiful(index, i))  
            {
                // action
                visited[i] = true;
                // recurse
                helper(num, index+1, visited);
                // backtrack
                visited[i] =false;
            }
        }
    }
     private boolean isBeautiful(int index, int i)
     {
         return  (index % i == 0 || i % index == 0);
     }
    
}