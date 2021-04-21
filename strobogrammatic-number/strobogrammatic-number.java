class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0)
            return false;
        HashMap<Character, Character> map = new HashMap();
        map.put('0','0');
        map.put('1','1');
        map.put('6','9');
        map.put('8','8');
        map.put('9','6');
        // reverse the given number
        StringBuilder sb = new StringBuilder();
        for (int i = num.length()-1; i>=0; i--){
            char c = num.charAt(i);
            if (!map.containsKey(c))
                return false;
            sb.append(map.get(c));
        }
        //return true if given number is not equal to the reversed number
        return num.equals(sb.toString());
    }
}