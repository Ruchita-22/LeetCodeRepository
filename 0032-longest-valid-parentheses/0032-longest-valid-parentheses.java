class Solution {
    public int longestValidParentheses(String s) {
       Stack<Integer> stack = new Stack<>();

        int maxLen = 0, starting_index = -1;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }
            else{
                if(stack.size()>0){
                     stack.pop();
                }
                else{
                    starting_index = i;
                    continue;
                }
                if(stack.size()>0){
                     maxLen = Math.max(maxLen, i-stack.peek());
                }
                else{
                    maxLen = Math.max(maxLen, i-starting_index);
                }
            }
        }
        return maxLen;
    }
    public int longestValidParentheses2(String s) {
        int ob = 0, cb = 0, max = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')      ob++;
            else cb++;
            if(ob == cb)    max = Math.max(max, 2*ob);
            else if(cb > ob){
                ob = 0;
                cb = 0;
            }
            
        }
        ob = 0;
        cb = 0;
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) == '(')      ob++;
            else cb++;
            if(ob == cb)    max = Math.max(max, 2*ob);
            else if (cb < ob){
                ob = 0;
                cb = 0;
            }
            
        }
        return max;
    }
}