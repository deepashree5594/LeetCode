class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
            return false;
        HashSet<String> set = new HashSet(wordDict);
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++){
            for (int j = 0; j < i; j++){
                if (dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }
}

// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
//             return false;
//         HashSet<String> set = new HashSet(wordDict);
//         return helper(s, set);
//     }
//     private boolean helper(String s, HashSet<String> set){
//         //base
//         if ( s.length() == 0)
//             return true;
        
//         //logic
//         for ( int i = 0; i < s.length() ; i++){
//             if (set.contains(s.substring(0, i+1)) && helper(s.substring(i+1), set))
//                 return true;
//         }
//         return false;
//     }
// }