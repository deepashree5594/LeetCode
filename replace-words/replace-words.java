class Solution {
    class TrieNode{
        boolean isWord;
        TrieNode[] child;
        public TrieNode(){
            this.isWord = false;
            this.child = new TrieNode[26];
        }
    }
    TrieNode root;
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for (String word: dictionary){
            insert(word);
        }
        String[] words = sentence.split("\\s+");
        for (int i = 0; i < words.length; i++){
            if (replace(words[i]) != null){
                words[i] = replace(words[i]);
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < words.length; i++){
            if (i > 0){
                res.append(' ');
            }
            res.append(words[i]);
        }
        return res.toString();
    }
    private String replace(String word){
       TrieNode curr = root;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.child[c-'a'] != null){
                sb.append(c);
                curr = curr.child[c-'a']; 
                
                if (curr.isWord)
                    break;
                }
             else
                break;
            }
          if (curr.isWord) 
              return sb.toString();
          return word;
    }
    private void insert(String word){
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (curr.child[c - 'a'] == null){
                curr.child[c-'a'] = new TrieNode();
            }
            curr = curr.child[c-'a'];
        }
        curr.isWord = true;
    }
}