// class Solution {
//     public List<String> wordBreak(String s, List<String> wordDict) {
        
//     }
// }
class Solution {
    //4ms , 73%
    List<String> result=new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        
      Set<String> set=new HashSet<>();
        for(String tmp:wordDict)
            set.add(tmp);
        
        helper(set,s,"");

        return result;
    }

    void helper(Set<String> set,String input,String out){

        if(input.length()==0){
            result.add(out.trim());
            return;
        }
        
        for(int i=0;i<input.length();i++){
            String left=input.substring(0,i+1);
            if(set.contains(left)){
                helper(set,input.substring(i+1),out+left+" "); //substring(i+1) is newString as input
            }

        }

    }
}