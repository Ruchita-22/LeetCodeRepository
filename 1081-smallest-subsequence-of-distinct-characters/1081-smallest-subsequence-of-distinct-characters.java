class Solution {

    public String smallestSubsequence(String s) {
        int freq[] = new int[26];
        int taken[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ci = s.charAt(i);
            freq[ci-'a'] = i;
        }


        var stack = new Stack<Character>();
        for (int i = 0; i < s.length() ; i++) {
            char ci = s.charAt(i);
            if(taken[ci-'a'] == 1) continue;

            while(stack.size() > 0 && stack.peek() > ci && freq[stack.peek()-'a'] > i){
                taken[stack.peek()-'a'] = 0;
                stack.pop();
            }
            stack.push(ci);
            taken[ci-'a'] = 1;
        }
        StringBuilder sb = new StringBuilder();
        while(stack.size() > 0) {
            sb.insert(0,stack.pop());
        }
        return  sb.toString();
    }
}