class TrieNode{
    TrieNode children[] = new TrieNode[26];
    int isEnd = 0;
}
class Encrypter {
    HashMap<Character, String> encode;
    HashMap<String, List<Character>> decode;
    TrieNode root; 
    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        
        encode = new HashMap();
        decode = new HashMap();
        
        for(int i = 0; i < keys.length; i++){
            encode.put(keys[i], values[i]);
            decode.putIfAbsent(values[i], new ArrayList<Character>());
            decode.get(values[i]).add(keys[i]);
        }
        
        root = new TrieNode();
        for(String s : dictionary)  insert(root, s);  
        
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
    
    public String encrypt(String s) {
        StringBuilder sb = new StringBuilder();
            
        for(char ci : s.toCharArray())
            sb.append(encode.get(ci));
            
        return new String(sb);
    }
    
    public int decrypt(String s) {
        TrieNode curr = root;
        return count(s, curr);
      
    }
    public int count(String word, TrieNode curr)
    {
        if(word.length() == 0)    return curr.isEnd;
        if(curr == null) return 0;
        
        int ans = 0;
        if(decode.containsKey(word.substring(0,2)) == false)      return 0;
        
        for(Character ch : decode.get(word.substring(0,2))) {
           
            if(curr.children[ch-'a'] != null)   
                ans += count(word.substring(2), curr.children[ch-'a']);
        }
        return ans;
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */