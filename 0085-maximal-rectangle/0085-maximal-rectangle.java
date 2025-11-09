class Solution {
    public int maximalRectangle(char[][] matrix) {
        int [] arr = new int[matrix[0].length];
        int res = 0;
        for(int i = matrix.length-1; i >=0 ; i--) {
            for(int j = 0; j < matrix[0].length; j++) {
                arr[j] = matrix[i][j] == '0' ? 0 : arr[j] + matrix[i][j]-'0';
            }
            res = Math.max(res, mah(arr));
        }
        return res;
    }
    public int mah(int[] heights) {
        int[] nsr_index = nsr_index(heights);
        int[] nsl_index = nsl_index(heights);
        int res = 0;
        for(int i = 0; i < heights.length; i++) {
            int area = heights[i] * (nsr_index[i] - nsl_index[i] - 1);
            res = Math.max(res, area);
        }
        return res;
        
    }
    private int[] nsr_index(int[] arr) {
        var stack = new Stack<Integer>();
        int res[] = new int[arr.length];
        for(int i = arr.length-1; i>= 0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            res[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);

        }
        return res;

    }
    private int[] nsl_index(int[] arr) {
        var stack = new Stack<Integer>();
        int res[] = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);

        }
        return res;
    }
}