// Recursion
class Solution {
    List<String> result;
    int targetSum;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList();
        targetSum = target;
        if ( num == null || num.length() == 0)
            return result;
         helper(num, "", 0, targetSum, 0, 0);
        return result;
    }
    private void helper(String num, String path, int pivotIndex, int targetSum, long calc, long tail)
    {
        //base
        if (pivotIndex == num.length())
        {
            if (calc == targetSum)
              result.add(path);
            return;
        }
    
            
        //logic
        for ( int i = pivotIndex; i < num.length(); i++)
        {
             // preceeding 0
            if ( pivotIndex != i && num.charAt(pivotIndex) == '0')
                continue;
            long curr = Long.parseLong(num.substring(pivotIndex, i+1));
            if ( pivotIndex == 0)
                helper(num, path + curr, i + 1, targetSum, curr, curr);
            else
            {
                // case 1: '+'
                 helper(num, path + "+" + curr, i + 1, targetSum, calc + curr, curr);
                // case 2: '-'
                 helper(num, path + "-" + curr, i + 1, targetSum, calc - curr, -curr);
                // case 3: '*' 
                 helper(num, path + "*" + curr, i + 1, targetSum, calc - tail + tail * curr, tail * curr);
            }
        }
    }
}