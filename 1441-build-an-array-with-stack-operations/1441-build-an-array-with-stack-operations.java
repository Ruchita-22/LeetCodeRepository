class Solution {
    public List<String> buildArray(int[] target, int n) {
        Stack<Integer> stack = new Stack();
        List<String> op = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        
        for(int i = 1; i <= n; i++) {
            if(idx == target.length)    break;
            
            stack.push(i);
            op.add("Push");
            if(i == target[idx]) {
                list.add(0,i);
                idx++;
            } else {
                stack.pop();
                op.add("Pop");
            }
            
            
        }
        return op;
        
        
    }
}
  