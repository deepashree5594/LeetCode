//https://www.youtube.com/watch?v=xmJZSYSvgfE&ab_channel=KnowledgeCenter 
//Greedy
// TC: O(N)
// SC: O(1)
// Did it run successfully on Leetcode? : Yes
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total_tank = 0;
        int curr_tank = 0;
        int starting_station = 0;
        for ( int i = 0; i < n; i++)
        {
            total_tank = total_tank + (gas[i] - cost[i]);
            curr_tank = curr_tank + (gas[i] - cost[i]);
            if (curr_tank < 0)
            {
                curr_tank = 0;
                starting_station = i+1;
            }
        }
        return total_tank >= 0 ? starting_station : -1;
    }
}