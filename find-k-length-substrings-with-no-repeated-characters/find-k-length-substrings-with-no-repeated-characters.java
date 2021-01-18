class Solution {
    public int numKLenSubstrNoRepeats(String S, int K) {
        if (S == null || S.length() == 0)
            return 0;
        int start = 0;
        int end = 0;
        int count = 0;
        HashSet<Character> set = new HashSet<Character>();
        while (end < S.length() && start < S.length())
        {
            if (!set.contains(S.charAt(end)))
                set.add(S.charAt(end++));
            else
               set.remove(S.charAt(start++));
            if (end-start == K)
            {
                count++;
                 set.remove(S.charAt(start++));
            }
        }
        return count;
    }
}
