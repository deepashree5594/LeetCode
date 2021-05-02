// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> it;
   Integer peekedValue;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    peekedValue = null;
        this.it = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
       if (peekedValue == null){
           peekedValue = it.next();
       }
        return peekedValue;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (peekedValue != null){     
            Integer returnValue = peekedValue;
            peekedValue = null;
            return returnValue;
        } else {
            return it.next();
        } 
	}
	
	@Override
	public boolean hasNext() {
	     if (peekedValue != null)
             return true;
         return it.hasNext();
	}
}