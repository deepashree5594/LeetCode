class RandomizedSet {
​
    /** Initialize your data structure here. */
    HashMap<Integer, Integer> map;
    List<Integer> list;
    Random rand = new Random();
    
    public RandomizedSet() {
       map = new HashMap();
       list = new ArrayList();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
       if (map.containsKey(val))
           return false;
       map.put(val, list.size());
       list.add(list.size(), val);
       return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val))
        {
            return false;
        } 
        int index = map.get(val);
        int lastElement = list.get(list.size()-1);
        list.set(index, lastElement);
        map.put(lastElement, index);
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
       return list.get(rand.nextInt(list.size()));
    }
}
​
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
