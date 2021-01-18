class Solution {
    public String removeVowels(String s) 
    {
        
    StringBuffer sb = new StringBuffer(s.length());
        
        // For each character in String S, see if its a vowel, if it isn't then add to StringBuffer
        for(int i = 0; i < s.length(); i++){
            if(!isVowel(s.charAt(i))){
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();     
    }
    
    // Using a function to check values, this makes it easy to control what to check for if things change
    public boolean isVowel(char c){
        // if list of things to check for grows, could switch to a hashset to minimize comparisons.
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }
        
        return false;    
        
        
    }
}
