class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList();
        int count = 0;
        for (List<Integer> point : points){
            int x = point.get(0) - location.get(0);
            int y = point.get(1) - location.get(1);
            if (x == 0 && y == 0 ){
                count++;
                continue;
            }
            angles.add(Math.atan2(y, x) * (180 / Math.PI));    
        }
        Collections.sort(angles);
        
        List<Double> tmp = new ArrayList<>(angles);
        
        for (double d : angles) 
            tmp.add(d + 360);

        //sliding window
        int start = 0;
        int result = count;
        //int end = 0;
        for ( int end = 0; end < tmp.size(); end++){
            while (tmp.get(end) - tmp.get(start) > angle) {
                start++;
            }
            result = Math.max(result, count + (end - start) + 1);
        }
      return result;
    }
}
        
        