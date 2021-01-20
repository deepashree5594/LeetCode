class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        if (boxTypes == null || boxTypes.length == 0 )
            return 0;
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        int unitCount = 0;
        
        for ( int[] boxType: boxTypes)
        {
             int boxCount = Math.min(truckSize, boxType[0]);
             unitCount = unitCount + (boxCount* boxType[1]);
             truckSize = truckSize - boxCount;
             if (truckSize == 0)
                 break;
        }
        return unitCount;
    }
}
