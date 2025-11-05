class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '[') stack.push(c);
            else if(stack.size() > 0 && c == ']') stack.pop();
        }
        return (stack.size() + 1)/2;
    }
}