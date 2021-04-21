class Solution {
    int count;
    HashMap<Integer, Integer> map;
    public int confusingNumberII(int N) {
        if (N < 1)
            return 0;
       count = 0;
       map = new HashMap();
       map.put(0, 0);
       map.put(1, 1);
       map.put(6, 9);
       map.put(8, 8);
       map.put(9, 6);
       dfs(N, 0);
      return count;
    }
    private void dfs(int N, long current){
        //base
        if (isValid(current)){
            count++;
            //return;
        }    
        //logic
        for (int num : map.keySet()){
            long nextNum = current * 10 + num;
            if (nextNum != 0 && nextNum <= N)
                  dfs(N, nextNum);
        }
    }
        
    private boolean isValid(long num){
        long original = num;
        long result = 0;
        while ( num > 0){
            result = result * 10 + map.get((int) num % 10);
            num = num / 10;
        }
        return result != original;
    }
}