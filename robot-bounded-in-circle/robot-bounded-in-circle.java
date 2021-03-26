class Solution {
    public boolean isRobotBounded(String instructions) {
        // IMP: directions should be in order : north, west, south, east ( clockwise direction)
        int[][] dirs = new int[][]{{-1, 0}, {0,-1}, {1,0}, {0,1}};
        int x = 0;
        int y = 0;
        int i = 0;
        for ( int k = 0; k < instructions.length(); k++){
            char c = instructions.charAt(k);
            if (c == 'L'){
                i = (i+1)%4;
            } else if (c == 'R'){
                i = (i+3)%4;
            } else {
                x = x + dirs[i][0];
                y = y + dirs[i][1];
            }
        }
        // if facing north or origin (0,0) return false
        return i!= 0 || (x == 0 && y == 0);
    }
}