// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

// TC: O(1) - all methods
// SC: O(1) - all methods
// Did it run successfully on Leetcode? : Yes
import java.util.NoSuchElementException;
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> it;
    Integer peekValue = null;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
         it = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
       if (peekValue == null)
       {
           if (it.hasNext())
               peekValue =  it.next();
       }
       return peekValue;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	  if (peekValue != null)
      {
          Integer toReturn = peekValue;
          peekValue = null;
          return toReturn;
      }
        if (!it.hasNext())
            throw new NoSuchElementException();
           return it.next();
	}
	
	@Override
	public boolean hasNext() {
	   return peekValue != null || it.hasNext();
	}
}



// TC: O(1) - all methods
// SC: O(1) - all methods
// Did it run successfully on Leetcode? : Yes
// import java.util.NoSuchElementException;

// class PeekingIterator implements Iterator<Integer> {

//     private Iterator<Integer> iter;
//     private Integer next = null;

//     public PeekingIterator(Iterator<Integer> iterator) {
//         // Avoid an exception being thrown in the constructor.
//         if (iterator.hasNext()) {
//             next = iterator.next();
//         }
//         iter = iterator;
//     }

//     public Integer peek() {
//         return next;
//     }

//     @Override
//     public Integer next() {
//         /* As per the Java Iterator specs, we should throw a NoSuchElementException
//          * if the next element doesn't exist. */
//         if (next == null) {
//             throw new NoSuchElementException();
//         }
//         Integer toReturn = next;
//         next = null;
//         if (iter.hasNext()) {
//             next = iter.next();
//         }
//         return toReturn;
//     }

//     @Override
//     public boolean hasNext() {
//         return next != null;
//     }
// }