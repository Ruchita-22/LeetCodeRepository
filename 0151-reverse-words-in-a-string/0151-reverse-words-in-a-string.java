class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        System.out.println(s);
        if(s.length() == 0) return "";

        String[] strs = s.split(" ");
        Stack<String> stack = new Stack();
        for(int i = 0 ; i < strs.length; i++) {
            if(strs[i].length() > 0) stack.push(strs[i]);
        }
        // int i = 0, j = strs.length-1;
        // while(i < j) {
        //     String t = strs[i];
        //     strs[i] = strs[j];
        //     strs[j] = t;
        //     i++; j--;
        // }
        String res = "";
        while(stack.size() > 1)
            res = res + stack.pop() + " ";
        return res + stack.pop();
        
    }
    private void print(String[] strs) {
        for(String str : strs) {
            System.out.println(str+" ");
        }
        System.out.println();
    }
}