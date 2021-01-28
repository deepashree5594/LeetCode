class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       HashMap<Integer, List<Integer>> map = buildHashMap(numCourses,prerequisites);
       int[] inDegree = buildInDegreeArray(numCourses,prerequisites);
       int[] result = new int[numCourses];
       Queue<Integer> queue = new LinkedList<>();
       for (int i = 0; i < inDegree.length; i++)
       {
           if (inDegree[i] == 0)
               queue.add(i);
       }
       
        
        int count = 0;
        int index = 0;
       while (!queue.isEmpty())
       {
           int currCourse = queue.poll();
           result[index++] = currCourse;
           count++;
           for (int dependentOnCurrCourse : map.get(currCourse))
           {
               inDegree[dependentOnCurrCourse]--;
               if (inDegree[dependentOnCurrCourse] == 0)
                   queue.add(dependentOnCurrCourse);
           }
       }
       if (count == numCourses) 
       {        
           return result;
       } 
        return new int[] {};
    }
    
    public HashMap<Integer, List<Integer>> buildHashMap(int numCourses, int[][] prerequisites)
    {
       HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
       for (int i = 0; i < numCourses; i++)
       {
           map.put(i, new ArrayList());
       }
       for (int i = 0; i < prerequisites.length; i++)
       {
           int courseX = prerequisites[i][1];
           int courseThatDepdendsOnX = prerequisites[i][0];
           map.get(courseX).add(courseThatDepdendsOnX);
       }
        return map;
    }
    
    public int[]  buildInDegreeArray(int numCourses, int[][] prerequisites)
    {
        int[] inDegree = new int[numCourses];
        for ( int i = 0; i < prerequisites.length; i++)
        {
            inDegree[prerequisites[i][0]]++;
        }
        return inDegree;
    }
}