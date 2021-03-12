class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if ( people == null || people.length == 0)
            return new int[][]{};
        List<int[]> q = new ArrayList();
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0])
            {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        
      //  [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
      //  [[7,0],[7,1],[6,1],[6,1],[5,0],[5,2]]
       for ( int[] person : people)
       {
           q.add(person[1], person);
       }
        int[][] result = new int[people.length][2];
       for ( int i = 0; i < q.size(); i++)
       {
           result[i] = q.get(i);
       }
        return result;
    }
}