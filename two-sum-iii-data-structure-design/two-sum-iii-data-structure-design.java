class TwoSum {
    HashMap<Integer, Integer> map; 
    /** Initialize your data structure here. */
    public TwoSum() {
        this.map = new HashMap();
    }
    
    /** Add the number to an internal data structure.. */
    // Tc : O(1)
    public void add(int number) {
        if (this.map.containsKey(number))
        {    
            this.map.put(number, this.map.get(number) + 1 );
        }
        else
        {
            this.map.put(number, 1);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    // TC : O(N)
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : this.map.entrySet())
        {
            int complement = value - entry.getKey();
            if (complement != entry.getKey())
            {
                if (this.map.containsKey(complement))
                    return true;
            } 
            else
            {
                if (entry.getValue() > 1)
                    return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */