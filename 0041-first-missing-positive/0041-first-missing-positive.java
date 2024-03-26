class Solution {
    public int firstMissingPositive(int[] arr) {
        
        int i = 0;
        while(i < arr.length) {
            
            if(arr[i] <= 0 || arr[i] > arr.length) i++;
            else {
                if(arr[arr[i]-1] == arr[i]) i++;
                else {
                    int corrIdx = arr[i]-1;
                    int temp = arr[corrIdx];
                    arr[corrIdx] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        i = 0;
        print(arr);
        while(i < arr.length){
            if(arr[i] != i+1)  return i+1;    
            i++;
        }
        return i+1;
    }
    private static void print(int arr[]) {
        for(int e : arr) {
             System.out.print(e+ " ");
        }
         System.out.println();
    }
}