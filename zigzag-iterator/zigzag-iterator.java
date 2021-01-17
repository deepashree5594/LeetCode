public class ZigzagIterator {
    Queue<Integer> queue;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList();
        int i = 0;
        int j = 0;
        while ( i < v1.size() && j < v2.size())
        {
            queue.add(v1.get(i++));
            queue.add(v2.get(j++));
        }
        while(i < v1.size())
        {
            queue.add(v1.get(i++));
        }
         while(j < v2.size())
        {
            queue.add(v2.get(j++));
        }
    }
​
    public int next() {
        if (hasNext())
            return queue.remove();
        return -1;
    }
​
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
​
/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
