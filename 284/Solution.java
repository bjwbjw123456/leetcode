// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Integer n;
    Iterator<Integer> iter;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    iter = iterator;
	    n = null;
	    if (iter.hasNext()) n = iter.next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return n;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer tmp = n;
	    if (iter.hasNext()) {
	        n = iter.next();
	    } else {
	        n = null;
	    }
	    return tmp;
	}

	@Override
	public boolean hasNext() {
	    return n!=null;
	}
}