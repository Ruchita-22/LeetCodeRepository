class Solution {
    public int calculate(String s) {
        var stack = new Stack<Integer>();
        int res = 0, num = 0, sign = 1;
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                num = num * 10 + c-'0';
            } else if(c == '+') {
                res += num*sign;
                num = 0; sign  = 1;
            } else if (c == '-') {
                res += num*sign;
                num = 0; sign  = -1;
            } else if(c == '(') {
                stack.push(res);
                stack.push(sign);
                sign = 1; res = 0;

            } else if(c == ')') {
                res += num * sign;
                num = 0; 
                res = res * stack.pop();
                res = res + stack.pop(); 

            }
        }
        if(num != 0) res += num*sign;
        return res;
    }
}