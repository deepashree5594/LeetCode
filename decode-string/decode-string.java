class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack();
        Stack<StringBuilder> stringStack = new Stack();
        int num = 0;
        StringBuilder currStr = new StringBuilder();
        String result = "";
        for ( int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if (Character.isDigit(ch))
            {
                num = num * 10 + (ch - '0');
            }
            else if (ch == '[')
            {
                numStack.push(num);
                stringStack.push(currStr);
                // reset the num and currStr
                num = 0;
                currStr = new StringBuilder();
            }
            else if (ch == ']')
            {
                int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for ( int j = 0; j < times; j++)
                {
                    newStr.append(currStr);
                }
                currStr = stringStack.pop().append(newStr);
            }
            // if (Character.isAlphabetic(ch))
            else 
            {
                currStr.append(ch);
            }
        }
        return currStr.toString();
    }
}
// class Solution {
//     public String decodeString(String s) {
//         int start = 0;
//         Stack<Integer> stackN = new Stack<Integer>();
//         Stack<String> stackS = new Stack<String>();
//         String res = "";
//         while (start < s.length())
//         {
//             if (Character.isDigit(s.charAt(start)))
//                 {
//                     int num = s.charAt(start) - '0';
//                     while (start+1 < s.length() && Character.isDigit(s.charAt(start+1)))
