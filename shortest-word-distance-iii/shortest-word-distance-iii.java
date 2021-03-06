class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        boolean areSame = word1.equals(word2);
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++){
            if (wordsDict[i].equals(word1)){
                if (areSame && index1 != -1){
                    index2 = index1;
                } 
                index1 = i;  
            } else if (wordsDict[i].equals(word2)){
                index2 = i;
            }
            if (index1 != -1 && index2 != -1)
                minDist = Math.min(minDist, Math.abs(index1 - index2));
        }
        return minDist;
    }
}