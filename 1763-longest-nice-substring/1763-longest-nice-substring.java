//https://www.youtube.com/watch?v=20mjBSByOaQ&t=210s
class Solution {
    public String longestNiceSubstring(String s) {
        if(s.length() < 2)  return "";
        HashSet<Character> set = new HashSet<>();
        
        for(char c : s.toCharArray()){
            set.add(c);
        }
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(set.contains(Character.toLowerCase(c)) && set.contains(Character.toUpperCase(c)))
                continue;
            String prev = longestNiceSubstring(s.substring(0, i));
            String next = longestNiceSubstring(s.substring(i+1));
            
            return prev.length() >= next.length() ? prev : next;
        }
        return s;
    }
}