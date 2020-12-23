class MinStack {
​
    /** initialize your data structure here. */
    
    // To store input
    Stack<Integer> stack;
    
    // To track minValues
    Stack<Integer> minStack;
    int min;
    
    public MinStack() {
        stack = new Stack();
        minStack = new Stack();
        min = Integer.MAX_VALUE;
        minStack.push(min);
    }    
    public void push(int x) {
       // If minStack is empty or the current element is less than the top element of minStack, then add the current element to minStack as well as to the stack that stores input. Otherwise, only add to the later stack.
       // if (minStack.isEmpty() || x <= minStack.peek())
       //          minStack.push(x);
       //  stack.push(x);
        min = Math.min(x, min);
        stack.push(x);
        minStack.push(min);
        
    }
    
    public void pop() {
        // If the Stack's and minStack's top element are same, pop that element from both the stacks, otherwise opo it only from the    input Stack
        // if (stack.peek().equals(minStack.peek()))
        //     minStack.pop();
        // stack.pop();
        stack.pop();
        minStack.pop();
        min = minStack.peek();
    }
    
    public int top() {
    // Input stack's top element can be found by just calling peek() on it.
      // return stack.peek();
        return stack.peek();
    }
    
    public int getMin() {
      // Since we are tracking min values in MinStack, the top of minStack will always have the minimum value so far. So just call peek() on minStack to get the minimum element
       // return minStack.peek();
        return min;
    }
}
​
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
