class Solution {
    public int maxArea(int[] height) {
        if ( height == null || height.length == 0)
            return 0;
        int result = 0;
        int i = 0;
        int j = height.length-1;
        while ( i < j){
            result = Math.max(result, Math.min(height[i], height[j]) * (j-i));
            if (height[i] < height[j]){
                i++;
            } else {
                j--;
            }
        }
        return result;
    }
}