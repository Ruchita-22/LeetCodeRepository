class Solution {
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        int closeBracketCount = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                if(closeBracketCount % 2 > 0) {
                    closeBracketCount--;
                    ans ++;
                }
                closeBracketCount += 2;
            } else {
                closeBracketCount--;
                if(closeBracketCount < 0){
                    closeBracketCount += 2;
                    ans++;
                }
            } 
        }
        
        return ans + closeBracketCount;
    }
}