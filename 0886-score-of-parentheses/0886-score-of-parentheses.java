class Solution {
    public int scoreOfParentheses(String s) {
        var stack = new Stack<Character>();

        for(char c : s.toCharArray()) {
            if(c == '(') stack.push(c);
            else if(stack.size() > 0 && stack.peek() == '(') {
                stack.pop();
                stack.push('1');
            } else if(stack.size() > 0 && stack.peek() != '(') {
                int sum = 0;
                while(stack.size() > 0 && stack.peek() != '(') {
                    sum += stack.pop() - '0';
                }
                stack.pop();
                stack.push((char)(2 * sum + '0'));
            }
        }
        int sum = 0;
        while(stack.size() > 0) {
            sum += (stack.pop() - '0');
        }

        return sum;
        
    }
}