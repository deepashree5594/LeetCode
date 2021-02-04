class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int left_max = 0;
        int right_max = 0;
        int result = 0;
        while ( left < right)
        {
           if (height[left] < height[right])
           {
               if (height[left] >= left_max )
               {    
                   left_max = height[left];
               }
               result = result + (left_max - height[left]);
               left++;
           }
          else
          {
              if (height[right] >= right_max )
               {    
                   right_max = height[right];
               }
              result = result + (right_max - height[right]);
              right--;
          }   
        }
        return result;
    }
}