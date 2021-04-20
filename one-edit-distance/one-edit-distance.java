class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if (tlen - slen > 1)
            return false;
        if (slen > tlen)
            return isOneEditDistance(t, s);
        int i = 0;
        int j = 0;
        while ( i < slen && j < tlen){
            if (s.charAt(i) != t.charAt(j)){
                if (slen == tlen){
                    return s.substring(i+1).equals(t.substring(j+1));
                } else {
                    return s.substring(i).equals(t.substring(j+1));
                }
            } 
            i++;
            j++;
        }
        return slen+1 == tlen;
    }
}