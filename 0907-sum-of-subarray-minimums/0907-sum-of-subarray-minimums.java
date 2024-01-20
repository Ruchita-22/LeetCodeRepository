class Solution {
    public int sumSubarrayMins(int[] arr) {
        int nslIndex[] = nslIndex(arr);
        int nsrIndex[] = nsrIndex(arr);
        int n = arr.length;
        long sum = 0;
        for(int i = arr.length-1; i >= 0; i--) {
          
            sum += arr[i] *1L* ( i - nslIndex[i]) * (nsrIndex[i] - i);
        }
        return (int)(sum % 1000000007);
    }
    public int[] nslIndex(int arr[]) {
        int res[] = new int[arr.length];
        Stack<Integer> stack = new Stack();
        for(int i = 0 ; i < arr.length; i++) {
            while(stack.size() > 0 && arr[stack.peek()] >= arr[i])   stack.pop();
            res[i] = stack.size() > 0 ? stack.peek() : -1;
            stack.add(i);
        }
        return res;
    }
    public int[] nsrIndex(int arr[]) {
        int res[] = new int[arr.length];
        Stack<Integer> stack = new Stack();
        for(int i =  arr.length-1; i >= 0; i--) {
            while(stack.size() > 0 && arr[stack.peek()] > arr[i])   stack.pop();
            res[i] = stack.size() > 0 ? stack.peek() : arr.length;
            stack.add(i);
        }
        return res;
    }
    
}