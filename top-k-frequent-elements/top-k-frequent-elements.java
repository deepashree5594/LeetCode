class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Store the frequency of every number in HashMap
        int res[] = new int[k];
        HashMap<Integer, Integer> map = new HashMap();
        for (int num:nums)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue maxHeap = new PriorityQueue((l1, l2) -> map.get(l1) - map.get(l2));
        
        for(int key: map.keySet())         
        {
            maxHeap.offer(key);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        for (int i = 0; i < k; i++)
        {
            res[i] = (int)maxHeap.poll();
        }
        return res;
    }
}
​
​
