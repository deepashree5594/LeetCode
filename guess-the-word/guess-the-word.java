// /**
//  * // This is the Master's API interface.
//  * // You should not implement it, or speculate about its implementation
//  * interface Master {
//  *     public int guess(String word) {}
//  * }
//  */
// //secret = "acckzz", wordlist = ["acckzz","ccbazz","eiowzz","abcczz"], numguesses = 10
// class Solution {
//     public void findSecretWord(String[] wordlist, Master master) {
//         Random rand = new Random();
//         int n = wordlist.length;
//         for (int i = 0; i < n; i++) {
//             int len = wordlist.length;
           
//             int index = rand.nextInt(len);
//             String guessWord = wordlist[index];
            
//             int x = master.guess(guessWord);
            
//             List<String> wordlist2 = new ArrayList<>();
//             for (String w : wordlist)
//                 if (match(guessWord, w) == x)
//                     wordlist2.add(w);
//             wordlist = wordlist2.toArray(new String[wordlist2.size()]);
//         }
//     }
//       public int match(String a, String b) {
//         int matches = 0;
//         for (int i = 0; i < a.length(); ++i)
//             if (a.charAt(i) == b.charAt(i))
//                 matches ++;
//         return matches;
//     }
// }

class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        Random rand = new Random();
        int n = wordlist.length;
        for (int x = 0,  i = 0; x < n || i < 10; i++, x++){
             n = wordlist.length;
            int index = rand.nextInt(n);    
            String guessWord = wordlist[index];
             x = master.guess(guessWord);
           
            
            List<String> wordList2 = new ArrayList();
            for (String word: wordlist){
                if (matches(word, guessWord) == x){
                      wordList2.add(word);
                }
            }
            wordlist = wordList2.toArray(new String[wordList2.size()]);             
        }
        
    }
    private int matches(String a, String b){
        int matches = 0;
        for ( int i = 0; i < a.length(); i++){
            if (a.charAt(i) == b.charAt(i))
                matches++;
        }
        return matches;
    }
}
