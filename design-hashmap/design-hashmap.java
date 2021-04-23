class MyHashMap {
    /** Initialize your data structure here. */
    int[][] array; 
    int n;
    public MyHashMap() {
        n = 1000;
        array = new int[n][n+1];
        for (int[] row : array){
            Arrays.fill(row, -1);
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index1 = key%n;
        int index2 = key/n;
        System.out.println("index1 = " + index1);
         System.out.println("index2 = " + index2);
        array[index1][index2] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
         int index1 = key%n;
         int index2 = key/n;
        int val =  array[index1][index2];
        if (val != -1)
            return val;
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index1 = key%n;
        int index2 = key/n;
        array[index1][index2] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */