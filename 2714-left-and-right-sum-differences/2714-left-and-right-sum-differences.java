class Solution {
    public int[] leftRightDifference(int[] arr) {
        int n = arr.length;
        int pfLeft[] = new int[n];
        int pfRight[] = new int[n];
        pfLeft[0] = 0;
        for(int i = 1; i < n; i++) {
            pfLeft[i] = pfLeft[i-1] + arr[i-1];
        }
        print(pfLeft);
        pfRight[n-1] = 0;
        for(int i = n-2; i >= 0; i--) {
            pfRight[i] = pfRight[i+1] + arr[i+1];
        }
        print(pfRight);
        int ans[] = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = Math.abs(pfLeft[i] - pfRight[i]);
        }
        return ans;
        
    }
    private void print(int arr[]) {
        for(int e : arr) {
            System.out.print(e+" ");
        }
        System.out.println();
    }
}