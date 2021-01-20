// Greedy
//TC: O(N)
//SC: O(1)
class Solution {
    public List<Integer> partitionLabels(String S) {
        if ( S == null || S.length() == 0)
            return new ArrayList();
        int[] lastIndexArray = new int[26];
        List<Integer> result = new ArrayList();
        for (int i = 0; i < S.length(); i++)
        {
            lastIndexArray[S.charAt(i) - 'a'] = i;
        }
        
        int j = 0;
        int anchor = 0;
        for ( int i = 0; i < S.length(); i++)
        {
            j = Math.max(j, lastIndexArray[S.charAt(i) - 'a']);
            if ( i== j)
            {
                result.add(i-anchor+1);
                anchor = i+1;
            }
        }
        return result;
    }
}
