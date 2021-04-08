class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        if ( logs == null || logs.length == 0)
            return new int[]{};
        int[] result = new int[k];
        HashMap<Integer, HashSet<Integer>> map = new HashMap();
        for (int[] log : logs){
            if (!map.containsKey(log[0])){
                map.put(log[0], new HashSet());
            }
            map.get(log[0]).add(log[1]);
        }
        for (int key: map.keySet()){
            result[map.get(key).size() - 1]++;
        }
        return result;
    }
}