// Time Complexity : O(N/B) : N - all possible input elements , B - no. of buckets
// Space Complexity : O(B + N) : N - no. of unique input elements, B - no. of buckets here it is 100
// Did this code successfully run on Leetcode : Yes
​
class MyHashSet {
​
    /** Initialize your data structure here. */
    
    // Creating a list of 100 buckets
    int bucketsSize;
    int bucketItemsSize;
    boolean buckets[][];
    boolean bucketItems[];
    
    public MyHashSet() {
     bucketsSize = 1000;
     bucketItemsSize = 1000;  
     buckets = new boolean[bucketsSize][];
    }
    
    private int getFirstHash(int key)
    {
        return key%bucketsSize;
    }
    private int getSecondHash(int key)
    {
        return key/bucketItemsSize;
    }
    
    public void add(int key) {
       int firstHashindex = getFirstHash(key);
       if (buckets[firstHashindex] == null)
       {
           buckets[firstHashindex] = new boolean[bucketItemsSize];
       }
       int secondHashIndex = getSecondHash(key);
       buckets[firstHashindex][secondHashIndex] = true;
          
    }
    
    public void remove(int key) {
       int firstHashindex = getFirstHash(key);
       if (buckets[firstHashindex] == null)
         return;
       int secondHashIndex = getSecondHash(key);
       buckets[firstHashindex][secondHashIndex] = false;
           
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int firstHashindex = getFirstHash(key);
        if (buckets[firstHashindex] == null)
          return false;
        int secondHashIndex = getSecondHash(key);
        return buckets[firstHashindex][secondHashIndex];
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
