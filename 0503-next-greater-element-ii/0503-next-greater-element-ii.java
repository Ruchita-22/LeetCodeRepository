class Solution {
    //approach 2
     public int[] nextGreaterElements(int[] arr) {
         
         Stack<Integer> stack = new Stack();
        
        for(int i = arr.length-1; i >= 0; i--) {
            while(stack.size() > 0 && stack.peek() <= arr[i]) stack.pop();
            stack.add(arr[i]);
        }
         
        int res[] = new int[arr.length];
         
        for(int i = arr.length-1; i >= 0; i--) {
            while(stack.size() > 0 && stack.peek() <= arr[i]) stack.pop();
            res[i] = stack.size() > 0 ? stack.peek() : -1;
            stack.add(arr[i]);
        }
        return res;
        

    }
    // approach 1
    /*
    public int[] nextGreaterElements(int[] arr) {
        int arr1[] = new int[2*arr.length];
        
        for(int i = 0; i < arr.length; i++) {
           arr1[i] = arr[i];
           arr1[arr.length+i] = arr[i]; 
        }  
        int ngr[] = ngr(arr1);
        //print(ngr);
        int res[] = new int[arr.length];
         for(int i = 0; i < arr.length; i++) {
           res[i] = ngr[i];
        }  
        return res;
        

    }
    public int[] ngr(int arr[]) {
        int res[] = new int[arr.length];
        Stack<Integer> stack = new Stack();
        
        for(int i = arr.length-1; i >= 0; i--) {
            while(stack.size() > 0 && stack.peek() <= arr[i]) stack.pop();
            res[i] = stack.size() > 0 ? stack.peek() : -1;
            stack.add(arr[i]);
        }
        return res;
    }
    */
    public void print(int arr[]) {
        for(int e : arr) {
            System.out.print(e+" ");
        }
        System.out.println();
    }   
    
}