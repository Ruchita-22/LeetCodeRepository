class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(c);
                ans = Math.max(ans, stack.size());
            } else if (c == ')') {
                if(stack.size() > 0 && stack.peek() == '(') stack.pop();
            } else {
                //do nothing
            }
        }
        return ans;
    }
}