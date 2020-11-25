            {
                inDegree.put(neighbor, inDegree.get(neighbor) -1  );
                if (inDegree.get(neighbor) == 0)
                    queue.add(neighbor);
            }
        }
        return index == org.length && index == inDegree.size();
    }
}
​
​
// public class Solution {
//     public boolean sequenceReconstruction(int[] org, int[][] seqs) {
//         Map<Integer, Integer> indegree = new HashMap<>();
//         Map<Integer, List<Integer>> graph = new HashMap<>();
//         // set up graph
//         for (int[] seq: seqs) {
//             if (seq.length == 1) {
//                 if (!indegree.containsKey(seq[0]))    indegree.put(seq[0], 0);
//                 if (!graph.containsKey(seq[0]))   graph.put(seq[0], new ArrayList<Integer>());
//             } else {
//                 for (int i = 0; i < seq.length-1; i++) {
//                     int prev = seq[i];
//                     int next = seq[i+1];
//                     // indegree-related
//                     if (!indegree.containsKey(prev))    indegree.put(prev, 0);
//                     if (!indegree.containsKey(next))    indegree.put(next, 0);
//                     indegree.put(next, indegree.get(next)+1);
//                     // edge-related
//                     if (!graph.containsKey(prev))   graph.put(prev, new ArrayList<Integer>());
//                     if (!graph.containsKey(next))   graph.put(next, new ArrayList<Integer>());
//                     graph.get(prev).add(next);
//                 }
//             }
//         }
//         // topological sort
//         Queue<Integer> queue = new LinkedList<>();
//         for (int node: indegree.keySet()) {
//             if (indegree.get(node) == 0)    queue.offer(node);
//         }
//         int index = 0;
//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             if (size > 1)   return false; // when size > 1, it means that there multiple ways of polling elements
//             int poll = queue.poll();
//             // index shouldnot arrive to the end of array yet
//             // check whether index==org.length to avoid the invalid getting element of org[index]
//             // uniqueness of sequence, we need to compare with org's corresponding element
//             if (index == org.length || poll != org[index])  return false;
//             index++;
//             for (int nb: graph.get(poll)) {
//                 int nb_indegree = indegree.get(nb) - 1;
//                 indegree.put(nb, nb_indegree);
//                 if (nb_indegree == 0)   queue.offer(nb);
//             }
//         }
//         return index == org.length && index == indegree.size(); // check cycle
//     }
// }
