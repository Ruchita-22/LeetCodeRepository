class TrieNode{
	TrieNode children[] = new TrieNode[26];
    int pf = 0;
	int isEnd = 0;
}   
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for(int i = 0; i < dictionary.size(); i++){
            insert(root, dictionary.get(i));
        }
        
        String words[] = sentence.split(" ");
        
        StringBuilder res = new StringBuilder();
        
        for(int i = 0; i < words.length; i++){
            
            String s = prefix(root, words[i]);
            res.append(s);
            res.append(" ");
        }
        return new String(res.substring(0,res.length()-1));  
        
    }
    private static void insert(TrieNode root, String s){
        TrieNode curr = root;
        for(int i = 0; i < s.length(); i++){
            char ci = s.charAt(i);
            if(curr.children[ci-'a'] == null){
                curr.children[ci - 'a'] = new TrieNode();
            }
            curr = curr.children[ci-'a'];
        }
        curr.isEnd = 1;
    }
    private static String prefix(TrieNode root, String s){
        TrieNode curr = root;
        
        boolean flag = false;
        int i = 0;
        for( i = 0; i < s.length(); i++){
            char ci = s.charAt(i);
            if(curr.children[ci - 'a'] != null){
                curr = curr.children[ci-'a'];
                if(curr.isEnd == 1) {
                    flag = true;
                    break;
                }    
            }
            else break;
            
        }
        //System.out.println(s + " " +flag);
        return flag == true ? s.substring(0, i+1) : s;
    }
}