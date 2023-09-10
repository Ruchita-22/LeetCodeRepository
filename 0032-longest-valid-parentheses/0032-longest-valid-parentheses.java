class Solution {
    public int longestValidParentheses(String s) {
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