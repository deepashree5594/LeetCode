class TimeMap {
​
    /** Initialize your data structure here. */
    HashMap<String, TreeMap<Integer, String>> map;
    
    public TimeMap() {
        map = new HashMap();        
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key))
        {
            map.put(key, new TreeMap());
        }
        map.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
         TreeMap<Integer, String> treeMap = map.get(key);
         if (treeMap == null )
            return "";
         Integer t = treeMap.floorKey(timestamp);
         if (t == null)
             return "";
         else
            return treeMap.get(t);
        
    }
}
​
/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
