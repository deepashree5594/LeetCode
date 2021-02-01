// https://www.youtube.com/watch?v=secuBlDy0YQ&ab_channel=AkshayGoyal
class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        // if ( cells == null || cells.length == 0 || N == 0 )
        //     return cells;
       
        boolean isCycle = false;
        HashSet<String> set = new HashSet();
     
        for ( int i = 0; i < N; i++)
        {
           int[] nextState = new int[8];
           for ( int j = 1; j < 7; j++)
           {
               nextState[j] = cells[j-1] == cells[j+1] ? 1: 0;
           }
           String s = Arrays.toString(nextState);
           if (!set.contains(s))
           {
               set.add(s);
           }
           else
           {
               isCycle = true;
               break;
           }
           cells = nextState;
        }
        
        if (isCycle)
        {
            N = N % set.size();
            for ( int i = 0; i < N ; i++)
            {
                int[] nextState = new int[8];
                for ( int j = 1; j < 7; j++)
                {
                  nextState[j] = cells[j-1] == cells[j+1] ? 1: 0;
                }
                cells = nextState;
            }
        }
        return cells;
    }
}