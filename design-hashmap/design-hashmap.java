    private int getSecondIndex(int key)
    {
        return Integer.hashCode(key) / childArrSize;
    }
    /** value will always be non-negative. */
    public void put(int key, int value) {
       int firstHashIndex = getFirstIndex(key);
       if (parentArr[firstHashIndex] == null)
       {
           parentArr[firstHashIndex] = new int[childArrSize];
           Arrays.fill(parentArr[firstHashIndex], -1);
       }
       int secondHashIndex = getSecondIndex(key);
       parentArr[firstHashIndex][secondHashIndex] = value;
    }
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
       int firstHashIndex = getFirstIndex(key);
        if (parentArr[firstHashIndex] == null)
            return -1;
        int secondHashIndex = getSecondIndex(key);
        return parentArr[firstHashIndex][secondHashIndex];
    }
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int firstHashIndex = getFirstIndex(key);
        if (parentArr[firstHashIndex] == null)
             return;
        int secondHashIndex = getSecondIndex(key);
        parentArr[firstHashIndex][secondHashIndex] = -1;
    }
}
// import java.io.*;
// class MyHashMap {
    
//     /** Initialize your data structure here. */
//     static class Node{
//         int key;
//         int value;
//         Node next;
        
//         Node(int key, int value)
//         {
//             this.key = key;
//             this.value = value;
//             this.next = null;
//         }  
//     }
    
//     Node[] nodes;
    
//     public MyHashMap() {
//         nodes = new Node[10000];
