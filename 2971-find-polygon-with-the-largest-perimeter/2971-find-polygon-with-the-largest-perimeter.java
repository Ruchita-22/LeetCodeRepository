class Solution {
    public long largestPerimeter(int[] arr) {
        Arrays.sort(arr);
        long remainingSideSum = 0, ans = 0;
        remainingSideSum = arr[0]+arr[1];
        for(int i = 2; i < arr.length; i++) {
            if(arr[i] < remainingSideSum) {
                ans = Math.max(ans, remainingSideSum+arr[i]);
            }
            remainingSideSum += arr[i];  
        }
        return ans != 0 ? ans : -1;
        
        
    }
}