
class Solution {
    public String reverseParentheses(String s) {
        var stack = new Stack<Integer>(); 
        int[] map = new int[s.length()];

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else if(s.charAt(i) == ')') {
                int j = stack.pop();
                map[j] = i;
                map[i] = j;
            }
        }
        int flag = 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i += flag) {
            if(s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = map[i];
                flag = -flag;
            } else {
               sb.append(s.charAt(i));
            }
        }
       
        return new String(sb);
        
    }
    
}