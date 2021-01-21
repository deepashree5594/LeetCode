// Method 3: HashMap and Array -- credit to @krrs.
// Count number then count occurrence:
​
// Count the occurrences of each number using HashMap;
// Using Array to count each occurrence, since max occurrence <= arr.length;
// From small to big, for each unvisited least frequent element, deduct from k the multiplication with the number of elements of same occurrence, check if reaching 0, then deduct the correponding unique count remaining.
class Solution
{
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : arr)
            count.put(a, 1 + count.getOrDefault(a, 0));
        int remaining = count.size(), occur = 1;
        int[] occurrenceCount = new int[arr.length + 1];
        for (int v : count.values())
            ++occurrenceCount[v];
        while (k > 0) {
            if (k - occur * occurrenceCount[occur] >= 0) {
                k -= occur * occurrenceCount[occur];
                remaining -= occurrenceCount[occur++];
            }else {
                return remaining - k / occur;
            }
        }
        return remaining;        
    }
}
