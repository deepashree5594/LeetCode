class Solution {
    public int singleNonDuplicate(int[] nums) {
        if ( nums == null || nums.length == 0)
            return Integer.MAX_VALUE;
        if ( nums.length == 1)
            return nums[0];
        
        int low = 0;
        int high = nums.length -1 ;
        while ( low < high)
        {
            int mid = low + (high-low)/2;
            if ( mid > 0 && nums[mid] == nums[mid-1])
            {
                if ( mid == 1 )
                   return nums[high]; 
                if ((mid - low) % 2 != 0)
                    low = mid + 1;
                else
                    high = mid - 2;
            }
            else if (mid < nums.length-1  && nums[mid] == nums[mid+1])
            {
                if (mid == nums.length-1)
                    return low;
                
                if ((high - mid) % 2 != 0)
                    high = mid - 1;
                else
                    low = mid + 2;
            }
            else
                return nums[mid];
        }
       return nums[low]; 
    }
}
