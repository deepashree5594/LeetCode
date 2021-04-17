//Backtracking
//TC:O(4^N)
//SC:O(N) -> recursive stack
class Solution {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length == 0)
            return false;
        int sum = 0;
        //calculate the sum of all matchsticks 
        for (int matchstick : matchsticks){
            sum = sum + matchstick;
        }
        //if the sum is not divisible by 4 then it is impossible to make a square, so return false
        if ( sum % 4 != 0)
            return false;
        //backtrack function to try placing different combinations of matchsticks to form a side and checking if a 4 such equal sides can be made to form a square
        
        return backtrack(matchsticks, 0, sum/4, new int [4]);
    }
    private boolean backtrack(int[] matchsticks, int index, int side, int[] square){
        //base
        if (index == matchsticks.length){
            if (square[0] == side && square[1] == side && square[2] == side)
                return true;
            else
                return false;
        }
            
        
        //logic
        for (int i = 0; i < square.length; i++){  //i-> 0 to 4
             if (square[i]  + matchsticks[index] <= side){
                 //action
                 square[i] = square[i] + matchsticks[index];
                 //recurse
                 if (backtrack(matchsticks, index+1, side, square))
                     return true;
                 //backtrack
                  square[i] = square[i] - matchsticks[index];
             }
        }
      return false;
    }
}