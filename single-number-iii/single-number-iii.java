class Solution {
    public int[] singleNumber(int[] nums) {
        int bitmask = 0;
        for (int num : nums){
            bitmask = bitmask ^ num;
        }
        int diff = bitmask & (-bitmask);
        int bitmask2 = 0;
        for (int num : nums){
            if ((diff & num) != 0){
                bitmask2 = bitmask2 ^ num;
            }
        }
        return new int[]{bitmask2, bitmask2^bitmask};
    }
}