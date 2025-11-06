class Solution {

    public String minRemoveToMakeValid(String s) {

        return minRemoveToMakeValid1(s);
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
}