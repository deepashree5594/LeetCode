class OrderedStream {
    String[] arr;
    int ptr;
    
    public OrderedStream(int n) {
        arr = new String[n];
        ptr = 0;
    }
    
    public List<String> insert(int id, String value) {
        List<String> list = new ArrayList<>();
        arr[id-1] = value;
        
        while (ptr < arr.length && arr[ptr] != null){
            list.add(arr[ptr]);
            ptr++;
        }
            return list;
    }
}
​
​
​
/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(id,value);
 */
