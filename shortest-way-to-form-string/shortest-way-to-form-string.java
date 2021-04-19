class Solution {
    public int shortestWay(String source, String target) {
        if ( source == null || source.length() == 0)
            return 0;
        int tp = 0;
        int sl = source.length();
        int tl = target.length();
        int count = 0;
        while (tp < tl){
            count++;
            int sp = 0;
            int curr = tp;
            while (sp < sl && tp < tl){
                if (source.charAt(sp) == target.charAt(tp)){
                    tp++;
                }
               sp++; 
            }
            if (curr == tp)
                return -1;
        }
        return count;
    }
}