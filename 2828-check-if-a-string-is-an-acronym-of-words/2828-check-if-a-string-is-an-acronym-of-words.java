class Solution {
    public boolean isAcronym(List<String> words, String s) {
        String s1 = "";
        for(String str : words) {
            s1 += str.charAt(0);
        }
        return s1.equals(s);
        
    }
}