    
    private Node find(int index, int key)
    {
        int i = getIndex(key);
        if ( nodes[i] == null)
            return nodes[index] = new Node(-1,-1);
        
        Node curr = nodes[i];
        Node prev = null;
        while ( curr != null && curr.key != key)
        {
             prev = curr;
             curr = curr.next;
        }
        return prev;
    }
    /** value will always be non-negative. */
    public void put(int key, int value) {
       int index = getIndex(key);
       if (nodes[index] == null) 
       {
           Node node = new Node(-1,-1);
       }
       Node prev = find(index, key);
       if (prev.next == null)
       {
           prev.next = new Node(key, value);
       }
       else
       {
         prev.next.value = value;
       }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
       int index = getIndex(key);
       if (nodes[index] == null) 
           return -1;
      Node prev = find(index, key);
       if (prev.next == null)
            return -1;
       return prev.next.value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
       int index = getIndex(key);
        if (nodes[index] == null) 
            return;
        Node prev = find(index, key);
        if (prev.next == null)
            return;
        else
            prev.next = prev.next.next;
        
    }
}
​
