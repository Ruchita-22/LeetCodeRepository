class Solution {

    public String minRemoveToMakeValid(String s) {

        return minRemoveToMakeValid2(s);
    }
    //approach 1
    private String minRemoveToMakeValid1(String s) {
        var stack = new Stack<Integer>();
        var set = new HashSet<Integer>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') { 
                stack.push(i);
                set.add(i);
            }
            else if(s.charAt(i) == ')' ) {
                if(stack.size() > 0) {
                    int idx = stack.pop();
                    set.remove(idx);
                } else {
                    set.add(i);
                }
                
            } else {
                //do nothing
            }
        }
        System.out.println(set);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char ci = s.charAt(i);
            if(ci == '(' || ci == ')') { 
                if(!set.contains(i))   sb.append(ci);
            }
            else {
                sb.append(ci);  
            } 
        }

        return new String (sb);
    }
    //approach 2
    private String minRemoveToMakeValid2(String s) {
        var open = 0;
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(c == '(') {
                open++;
                sb.append(c);
            } else if(c == ')') {
                if(open > 0) {
                    open--;
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }
        var close = 0;
        s = new String(sb);
        sb = new StringBuilder();
        for(int i = s.length()-1; i >= 0; i--) {
            char c = s.charAt(i);
            if(c == ')') {
                close++;
                sb.insert(0,c);
            } else if(c == '(') {
                if(close > 0) {
                    close--;
                    sb.insert(0,c);
                }
            } else {
                sb.insert(0,c);
            }
        }
        return new String(sb);
    }
}