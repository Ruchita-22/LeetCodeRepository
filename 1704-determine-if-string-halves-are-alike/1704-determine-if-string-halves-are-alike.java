class Solution {
    public boolean halvesAreAlike(String s) {
        int i = 0, j = s.length()-1;
        int vs = 0, ve = 0;
        Set<Character> set = Set.of('a','e','i','o','u', 'A', 'E', 'I', 'O', 'U');
        while(i < j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if(set.contains(ci)) vs++;
            if(set.contains(cj)) ve++;
            i++; j--;
        }
        return vs == ve;
        
    }
}