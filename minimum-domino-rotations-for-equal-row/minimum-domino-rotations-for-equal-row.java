class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        if (A == null || A.length == 0 || B == null ||  B.length == 0 )
            return -1;
        int maxFreqElement = -1;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < A.length; i++){
            int first = A[i];
            int firstCount = map.getOrDefault(first, 0) + 1;
            map.put(first,map.getOrDefault(first, 0) + 1);
            
            if (firstCount >= A.length){
                maxFreqElement = A[i];
            }
            
            int second = B[i];
            int secondCount = map.getOrDefault(second, 0) + 1;
            map.put(second,map.getOrDefault(second, 0) + 1);
            
            if (secondCount >= A.length){
                maxFreqElement = B[i];
            }    
        }
        int aRotations = 0;
        int bRotations = 0;
        for (int i = 0; i < A.length; i++){
            if (A[i] != maxFreqElement && B[i]!= maxFreqElement){
                return -1;
            }else if (A[i] != maxFreqElement) {
                aRotations++;
            } else if (B[i] != maxFreqElement) {
                bRotations++;
            }
        }
        return Math.min(aRotations, bRotations);
    }
}