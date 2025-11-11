class Solution {
    public int sumSubarrayMins(int[] heights) {
        int[] nsr_index = nsr_index(heights);
		int[] nsl_index = nsl_index(heights);
		long res = 0;
		for (int i = 0; i < heights.length; i++) {
			long area = heights[i] * 1L * (i - nsl_index[i]) * (nsr_index[i] - i);
			res += area;
		}
		return (int)(res % 1000000007);  
        
    }

	private int[] nsr_index(int[] arr) {
		Stack<Integer> stack = new Stack<Integer>();
		int res[] = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
				stack.pop();
			res[i] = stack.isEmpty() ? arr.length : stack.peek();
			stack.push(i);

		}
		return res;

	}

	private int[] nsl_index(int[] arr) {
		Stack<Integer> stack = new Stack<Integer>();
		int res[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
				stack.pop();
			res[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(i);

		}
		return res;
	}
}
/*
     1 2 3 4

        4*1 = 4
        3*2 = 6
        2*3 = 6
        1*4 = 4

        as its subarray so no sorting


        it is like mah 

*/