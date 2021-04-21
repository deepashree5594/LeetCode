class Solution {
    public boolean confusingNumber(int N) {
     if (N < 1)
        return false;
      HashMap<Integer, Integer> map = new HashMap();
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);
        long original = N;
        int result = 0;
        while ( N > 0){
            if (!map.containsKey(map.get((int)N % 10)))
                return false;
            result = result * 10 + map.get((int)N % 10);
            N = N / 10;
        }
        return result != original;
    }
}