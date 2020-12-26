       //  stack.push(x);
        
        
        
        // min = Math.min(x, min);
        // stack.push(x);
        // minStack.push(min);
        
        
        if ( x <= min)
        {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        // If the Stack's and minStack's top element are same, pop that element from both the stacks, otherwise opo it only from the    input Stack
        // if (stack.peek().equals(minStack.peek()))
        //     minStack.pop();
        // stack.pop();
        
        // stack.pop();
        // minStack.pop();
        // min = minStack.peek();
        
        
         int poppedElement = stack.pop();
         if (poppedElement == min)
         {
             min = stack.pop();
         }
    }
    
    public int top() {
    // Input stack's top element can be found by just calling peek() on it.
      // return stack.peek();
        
        
        //return stack.peek();
        
        return stack.peek();
    }
    
    public int getMin() {
      // Since we are tracking min values in MinStack, the top of minStack will always have the minimum value so far. So just call peek() on minStack to get the minimum element
       // return minStack.peek();
       
        
        
        //return min;
        
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
