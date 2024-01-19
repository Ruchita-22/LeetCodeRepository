class Solution {
    public int largestRectangleArea(int[] heights) {
        int nslIndex[] = nslIndex(heights);
        int nsrIndex[] = nsrIndex(heights);
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++) {
            int area = (nsrIndex[i] - nslIndex[i] - 1) * heights[i];
            ans = Math.max(ans, area);
            ans = Math.max(ans, heights[i]);
        }
        return ans;
    }
    public int[] nslIndex(int arr[]) {
        int res[] = new int[arr.length];
        Stack<Integer> stack = new Stack(); // store index
        
        for(int i = 0; i < arr.length; i++) {
            while(stack.size() >0 && arr[stack.peek()] >= arr[i])
                stack.pop();
            res[i] = stack.size() > 0 ? stack.peek() : -1;
            stack.push(i);
        }
        return res;
    }
    public int[] nsrIndex(int arr[]) {
        int res[] = new int[arr.length];
        Stack<Integer> stack = new Stack(); // store index
        
        for(int i = arr.length-1; i >= 0; i--) {
            while(stack.size() >0 && arr[stack.peek()] >= arr[i])
                stack.pop();
            res[i] = stack.size() > 0 ? stack.peek() : arr.length;
            stack.push(i);
        }
        return res;
    }
}