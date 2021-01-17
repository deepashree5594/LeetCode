import java.util.NoSuchElementException;
class Vector2D {
    int[][] vector;
    int outer = 0;
    int inner = 0;
    public Vector2D(int[][] v) {
        vector = v;
    }
    private void advanceRowPointer()
    {
        while ( outer < vector.length && inner == vector[outer].length)
        {
            inner = 0;
            outer++;
        }
    }
    
    public int next() {
        if (!hasNext()) throw new NoSuchElementException();
            
        return vector[outer][inner++];
    }
    
    public boolean hasNext() {
        advanceRowPointer();
        return outer < vector.length;
    }
}
​
/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
