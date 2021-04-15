// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> itr;
    Integer peekedValue = null;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.itr = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (peekedValue == null)
        {
          if (itr.hasNext()){
             peekedValue = itr.next();
            }
	     }
        return peekedValue;
    }
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
            if (peekedValue != null){
                System.out.println(" next() peekedValue = " + peekedValue );
                Integer returnValue = peekedValue;
                peekedValue = null;
                return returnValue;
            }
            else {
                  return itr.next();      
            }
        }
	
	@Override
	public boolean hasNext() {
        if (peekedValue != null){
            return true;
        }
	    return itr.hasNext();
	}
}