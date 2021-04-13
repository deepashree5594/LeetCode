//deeedbbd
class Solution {
    public String removeDuplicates(String s, int k) {
        if (s == null || s.length() == 0)
            return "";
        Stack<Character> charStack = new Stack();
        Stack<Integer> counter = new Stack();
        charStack.push(s.charAt(0));
        counter.push(1);
        for (int i = 1; i < s.length(); i++){
            char c = s.charAt(i);
            if(!charStack.isEmpty() && charStack.peek() == c){
                charStack.push(c);
                counter.push(counter.pop()+1);
                if (counter.peek() == k){
                    int n = k;
                    while (n > 0){
                        if (!charStack.isEmpty()){
                            charStack.pop();
                            n--;
                        }
                        
                    }
                    counter.pop();
                }
            }
            else{
                 charStack.push(c);
                 counter.push(1);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!charStack.isEmpty()){
            sb.append(charStack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}