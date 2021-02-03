class MedianFinder {
    PriorityQueue<Integer> lowers;       //maxHeap
    PriorityQueue<Integer> highers;      //minHeap
    /** initialize your data structure here. */
    public MedianFinder() {
        lowers =  new PriorityQueue<Integer>((a,b) -> b - a);
        highers = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
      if (lowers.size() == 0 || num < lowers.peek() )
          lowers.add(num);
      else
          highers.add(num);
        
    // Balance
      PriorityQueue<Integer> biggerHeap  =  lowers.size() > highers.size() ?  lowers : highers;
      PriorityQueue<Integer> smallerHeap =  lowers.size() > highers.size() ?  highers : lowers ;
        
      if (biggerHeap.size() - smallerHeap.size() >= 2)
      {
          smallerHeap.add(biggerHeap.poll());
      }
   
    }
    
    public double findMedian() {  
       PriorityQueue<Integer> biggerHeap  =  lowers.size() > highers.size() ?  lowers : highers;
       PriorityQueue<Integer> smallerHeap =  lowers.size() > highers.size() ?  highers : lowers ;
        
        
        if (biggerHeap.size() == smallerHeap.size())
            return ((double)biggerHeap.peek() + smallerHeap.peek()) * 0.5;
        else
            return biggerHeap.peek();
        
        // if (lowers != null && lowers.size() == highers.size())
        // {
        //   return (double)(lowers.peek() + highers.peek()) * 0.5;
        // }
        //  return highers.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */