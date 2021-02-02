class Logger {

    /** Initialize your data structure here. */
   HashMap<String,Integer> h1;
    
     public Logger() 
    {
       h1 = new HashMap<String,Integer>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) 
    {
    if (!this.h1.containsKey(message))
    {
        this.h1.put(message,timestamp);
        return true;
    }
    Integer oldtimestamp = this.h1.get(message);
    if (timestamp-oldtimestamp>=10)
    {
        this.h1.put(message, timestamp);
        return true;
    }
    else
    {
        return false;
    }
        
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */