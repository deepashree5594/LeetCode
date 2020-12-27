/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y] 
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     public int compareSub(int l, int r, int x, int y) {}
 *
 *     // Returns the length of the array
 *     public int length() {}
 * }
 */
​
class Solution {
public int getIndex(ArrayReader reader) {
    int l = 0, r = reader.length() - 1;
    
    while (l <= r) {
        int m = l + (r - l) / 2;
        int val;
        if ((r - l) % 2 == 0) {
            val = reader.compareSub(l, m, m, r);
        } else {
            val = reader.compareSub(l, m, m + 1, r);
        }
        
        if (val == 1) {
            r = m;
        } else if (val == -1) {
            l = m + 1;
        } else if (val == 0) {
            return m;
        }
    }
    
    return l;
}
}
