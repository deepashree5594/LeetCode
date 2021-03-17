class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0)
            return "";
        HashMap<Character, List<Character>> adjList = new HashMap();
        HashMap<Character, Integer> inDegree = new HashMap();
        
        for (String word : words)
        {
            for (char c : word.toCharArray())
            {
                inDegree.put(c, 0);
                adjList.put(c, new ArrayList());
            }
        }

        for (int i = 0; i < words.length-1; i++)
        {
            String word1 = words[i];
            String word2 = words[i+1];
            
             // word2 should not be a prefix of word1
            if (word1.length() > word2.length() && word1.startsWith(word2))
                    return "";
            
            for ( int j = 0; j < Math.min(word1.length(), word2.length()); j++)
            {
                if (word1.charAt(j) != word2.charAt(j))
                {
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    inDegree.put(word2.charAt(j), inDegree.getOrDefault(word2.charAt(j), 0) + 1);
                    break;
                }
                
            }
        }
        // BFS
        Queue<Character> q = new LinkedList();
        for (Character c: inDegree.keySet())
        {
            // add all independent nodes to queue
            if (inDegree.get(c) == 0)
                q.offer(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty())
        {
            Character currChar = q.poll();
            sb.append(currChar);
            for (Character neighbor : adjList.get(currChar))
            {
               if (inDegree.containsKey(neighbor))
               {
                   inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                   if (inDegree.get(neighbor) == 0)
                   {
                       q.offer(neighbor);
                   }
               }
            }
        }
        if (sb.length() < inDegree.size())
            return "";
        
        return sb.toString();
   }
}

// class Solution {
//     class Node
//     {
//         char val;
//         Node prev;
//         Node next;
//         Node(char v)
//         {
//             this.val = v;
//         }
//     }
//         Node head;
//         Node tail;
//         HashMap<Character, Node> map;
    
//     public String alienOrder(String[] words) {
//         this.head = new Node('.');
//         this.tail = new Node('.');
//         this.head.next = tail;
//         this.tail.prev = head;
//         this.map = new HashMap();
//         if (words == null || words.length == 0)
//             return "";
//         for (int i = 0; i < words.length -1 ; i++)
//         {
//             String word1 = words[i];
//             String word2 = words[i+1];
//             int len1 = word1.length();
//             int len2 = word2.length();
//             int minLen = Math.min(len1, len2);
//             for (int j = 0; j < minLen; j++)
//             {
//                 if (word1.charAt(j) == (word2.charAt(j)))
//                 {
//                     if(!map.containsKey(word1.charAt(j)))
//                     {
//                         Node newNode1 = new Node(word1.charAt(j));
//                         map.put(word1.charAt(j), newNode1);
//                         if (j != 0)
//                         {
//                               Node prevNode = map.get(word1.charAt(j-1));
//                               if (prevNode != null && newNode1 != null)
//                                    insertNode(prevNode,newNode1);
//                         }
//                         else
//                         {
//                             if (newNode1!= null)
//                               insertNodeAtTail(newNode1);
//                         }
//                     }
//                 }
//                 else
//                 { 
//                     Node newNode1 = null;
//                     Node newNode2 = null;
//                     if(map.containsKey(word1.charAt(j)))
//                     {
//                         continue;
//                     }
//                     if(map.containsKey(word2.charAt(j)))
//                     {
//                         continue;
//                     }
//                     if(!map.containsKey(word1.charAt(j)))
//                     {
//                         newNode1 = new Node(word1.charAt(j));
//                         map.put(word1.charAt(j), newNode1);
                       
//                     }
//                     if(!map.containsKey(word2.charAt(j)))
//                     {
//                         newNode2 = new Node(word2.charAt(j));
//                         map.put(word2.charAt(j), newNode2);
                       
//                     }
//                     if (j != 0)
//                     {
//                        Node prevNode = map.get(word1.charAt(j-1));
//                        if (prevNode != null && newNode1 != null)  insertNode(prevNode, newNode1);
//                        if (newNode1 != null && newNode2 != null)  insertNode(newNode1, newNode2);   
//                     }
//                     else
//                     {
//                         Node prevNode = map.get(word1.charAt(j));
//                         if (newNode2 != null && prevNode != null )   insertNode(prevNode, newNode2);
//                     }
//                  }
                      
//               }
//            }
//           return getResult(head);
//         }
        
//         private void insertNode(Node node1, Node node2)
//         {
//             Node nextNode = node1.next;
//             node1.next = node2;
//             node2.prev = node1;
//             nextNode.prev = node2;
//             node2.next = nextNode;
//         }
//         private void insertNodeAtTail(Node node)
//         {
//             Node tailPrev = tail.prev;
//             tailPrev.next = node;
//             node.prev = tailPrev;
//             node.next = tail;
//         }
//         private String getResult(Node head)
//         {
//             StringBuilder sb = new StringBuilder();
//             Node curr = head.next;
            
//             while (curr.next != null)
//             {
//                 sb.append(curr.val);
//                 curr = curr.next;
//             }
//             return sb.toString();
//         }
// }