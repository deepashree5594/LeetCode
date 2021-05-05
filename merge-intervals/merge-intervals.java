class Solution {
    public int[][] merge(int[][] intervals) 
    {
       if(intervals.length <=1)
       {
           return intervals;
       }
        
       Arrays.sort(intervals,(arr1,arr2)->Integer.compare(arr1[0],arr2[0]));
        
       List<int[]> output=new ArrayList<>();
        
       int[] current_int = intervals[0];
       output.add(current_int);
        
       for(int [] interval:intervals)
       {
           int current_begin=current_int[0];
           int current_end=current_int[1];
           int next_begin=interval[0];
           int next_end=interval[1];
           
           if(current_end>=next_begin)
           {
               current_int[1]=Math.max(current_end,next_end);
           }
           else
           {
               current_int=interval;
               output.add(current_int);
           }
       }
       return output.toArray(new int[output.size()][]); 
    }
}