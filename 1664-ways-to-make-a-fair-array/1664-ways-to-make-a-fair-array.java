class Solution {
    public int waysToMakeFair(int[] arr) {
        int n = arr.length;
        int pfEven[] = pfEvenConstruct(arr);
        int pfOdd[] = pfOddConstruct(arr);
        int ans = 0;
        for(int i=0;i<arr.length;i++)
        {   int t_odd, t_even;
         
            if(i==0){
                t_odd = pfEven[n-1] - pfEven[i];
                t_even = pfOdd[n-1] - pfOdd[i];
            }
            else {
                t_odd = pfOdd[i-1] + pfEven[n-1] - pfEven[i];
                t_even = pfEven[i-1] + pfOdd[n-1] - pfOdd[i];
            }
            if(t_odd == t_even) ans++;
        }  
        return ans;
    }
    
    private static int[] pfEvenConstruct(int arr[]){
        int pf[] = new int[arr.length];
        pf[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            if(i%2==0){
                pf[i] = pf[i-1]+arr[i];
            }
            else{
                pf[i] = pf[i-1];
            }
        }
        return pf;
    }
    private static int[] pfOddConstruct(int arr[]){
        int pf[] = new int[arr.length];
        pf[0] = 0;
        for(int i=1;i<arr.length;i++){
            if(i%2==0){
                pf[i] = pf[i-1];
            }
            else{
                pf[i] = pf[i-1]+arr[i];
            }
        }
        return pf;
    }
    
    
}