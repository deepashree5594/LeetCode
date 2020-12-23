class MyHashSet {
​
    /** Initialize your data structure here. */
    List<List<Integer>> parentList;
    int maxSize = 100;
    
    public MyHashSet() {
      parentList = new ArrayList<>(maxSize);        
      for(int i = 0; i < maxSize; i++)
      {
          parentList.add(null);
      }
    }
    
    public void add(int key) {
        int index = key % maxSize;
        List<Integer> list = parentList.get(index);
        if ( list == null)
        {
            list = new ArrayList();
            list.add(key);
            parentList.set(index, list);
        }
        else
        {
            if (!list.contains(key))
                list.add(key);
        }
    }
    
    public void remove(int key) {
        int index = key % maxSize;
        List<Integer> list = parentList.get(index);
        if ( list != null)
        {
            list.remove(Integer.valueOf(key));
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = key % maxSize;
        List<Integer> list = parentList.get(index);
        return (list != null && list.contains(key));
        
    }
}
​
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
