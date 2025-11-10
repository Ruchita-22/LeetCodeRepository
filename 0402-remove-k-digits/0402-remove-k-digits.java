class Solution {
    public String removeKdigits(String num, int k) {
        if(k >= num.length()) return "0";
        
        Stack<Integer> stack  = new Stack<>();
        for(char c : num.toCharArray()) {
            int n = c-'0';
            while(stack.size() > 0 && stack.peek() > n && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(n);
        }
        //System.out.println(stack);
        StringBuilder sb = new StringBuilder();
        while(stack.size() > 0) {
            sb.insert(0,(char)(stack.pop() + '0'));
        }
        String ans = sb.toString();
        if(k > 0) {
            ans = ans.substring(0, ans.length()-k);
        }

        int  i = 0;
        while(i < ans.length() && ans.charAt(i) == '0') {
            i++;
        }
        ans = ans.substring(i,ans.length());
        return ans.equals("") ? "0" : ans;
    }
}