class Trie { 
    TrieNode root;
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        TrieNode()
        {
            isEnd = false;
            children = new TrieNode[26];
        }
    }
    public Trie()
    {
        root = new TrieNode();
    }
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for ( int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if (cur.children[c-'a'] == null)
            {
                cur.children[c-'a'] = new TrieNode();
            }
            cur = cur.children[c-'a'];
        }
        cur.isEnd = true;
    }
     /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for ( int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if (cur.children[c-'a'] == null)
                  return false;
             cur = cur.children[c-'a'];
        }
        return cur.isEnd; 
    }
     /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for ( int i = 0; i < prefix.length(); i++)
        {
            char c = prefix.charAt(i);
            if (cur.children[c-'a'] == null)
                  return false;
            cur = cur.children[c-'a'];
        }
        return true;
    }
}

// class Trie { 
//     class TrieNode{
//         Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
//         boolean endOfWord;
        
//        TrieNode()
//        {
//            children = new HashMap<Character, TrieNode>();
//            endOfWord = false;
//        }
//     }
//     TrieNode root;
//     /** Initialize your data structure here. */
//     public Trie() {
//         root = new TrieNode();
//     }
    
//     /** Inserts a word into the trie. */
//     public void insert(String word) {
//         TrieNode current = root;
//         for ( int i = 0; i < word.length(); i++)
//         {
//             char ch = word.charAt(i);
//             TrieNode node = current.children.get(ch);
//             if ( node == null)
//             {
//                 node = new TrieNode();
//                 current.children.put(ch, node);
//             }
//             current = node;
//         }
//         current.endOfWord = true;
//     }
    
//     /** Returns if the word is in the trie. */
//     public boolean search(String word) {
//         TrieNode current = root;
//         for ( int i = 0; i < word.length(); i++)
//         {
//             char ch = word.charAt(i);
//             TrieNode node = current.children.get(ch);
//             if ( node == null )
//                 return false;
//             current = node;                    
//         }
//         return current.endOfWord;
//     }
    
//     /** Returns if there is any word in the trie that starts with the given prefix. */
//     public boolean startsWith(String prefix) {
//         TrieNode current = root;
//         for ( int i = 0; i < prefix.length(); i++)
//         {
//             char ch = prefix.charAt(i);
//             TrieNode node = current.children.get(ch);
//             if ( node == null )
//                 return false;
//             current = node; 
//         }
//            return true;
// }
// }

// /**
//  * Your Trie object will be instantiated and called as such:
//  * Trie obj = new Trie();
//  * obj.insert(word);
//  * boolean param_2 = obj.search(word);
//  * boolean param_3 = obj.startsWith(prefix);
//  */