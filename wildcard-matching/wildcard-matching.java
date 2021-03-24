class Solution {
    public boolean isMatch(String s, String p) {
        if (s.equals(p) || p.equals('*'))
            return true;
        int sLen = s.length();
        int pLen = p.length();
        boolean dp[][] = new boolean[pLen+1][sLen+1];
        dp[0][0] = true; //  empty string matches empty string 
        for ( int i = 1; i < dp.length; i++){
            char c = p.charAt(i-1);
            if (c == '*'){
                // 2 cases
                //first case
                int j = 0;
                while (j < dp[0].length) {
                  if (j == 0){ //only one case
                     dp[i][j] = dp[i-1][j];
                  }
                  else{
                      dp[i][j] =  dp[i-1][j-1] || dp[i-1][j];
                  }
                  if (dp[i][j]){
                      while (j < dp[0].length) {
                          dp[i][j] = true;
                          j++;
                      }
                  }
                 j++;
                }
            } else if (c == '?'){
                for (int j = 1; j < dp[0].length; j++){
                      dp[i][j] =  dp[i-1][j-1];
                 }
            } else {
                for (int j = 1; j < dp[0].length; j++){
                    if (c == s.charAt(j-1)){
                        dp[i][j] =  dp[i-1][j-1];
                    }
                } 
            }
        }
        return dp[dp.length-1][dp[0].length-1];
     }
}