// best way to solved this is trie
class TrieNode{
    TrieNode[] children = new TrieNode[26];
    ArrayList<String> list = new ArrayList<>();
}
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        
        TrieNode root = new TrieNode();
         for(int i = 0; i < products.length; i++){
            insert(root, products[i]);
        }
        
        List<List<String>> res = new ArrayList<>();
        
        for(int i = 0; i < searchWord.length(); i++){
            String s = searchWord.substring(0,i+1);
            List<String> temp = query(root, s);
            res.add(temp);
        }
        return res;
        
    }
    private static void insert(TrieNode root, String str){
        TrieNode curr = root;

        for(int i=0;i<str.length();i++){
            char ci = str.charAt(i);
            if(curr.children[ci-'a']==null){
                curr.children[ci-'a'] = new TrieNode();
            }
            curr = curr.children[ci-'a'];
            if(curr.list.size()<3)
            curr.list.add(str);
           
        }
    }
    private static List<String> query(TrieNode root, String str){
        TrieNode curr = root;

        for(int i=0;i<str.length();i++){
            char ci = str.charAt(i);
            curr = curr.children[ci-'a'];
            if(curr == null)    break; 
        }
        if(curr==null || curr.list.size()==0)   return new ArrayList<>();
        else return curr.list;
        
    }
    
}