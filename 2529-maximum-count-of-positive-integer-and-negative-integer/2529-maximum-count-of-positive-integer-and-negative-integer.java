class Solution {
    public int maximumCount(int[] arr) {
        int n = arr.length;
        if(n == 0) return 0;                            // no element
        if(arr[0]<0 && arr[n-1]<0)  return n;           // all -ve
        if(arr[0]>0 && arr[n-1]>0)  return n;           // all +ve
        if(arr[0] == 0 && arr[n-1] == 0)  return 0;     // all 0
        
        //search ceil and floor of 0
        int in = bs_first(arr,0); 
        int ip = bs_last(arr,0); 
        //System.out.println(in+" "+ip);
        int nn = in+1; 
        int pn = n -1 - ip + 1;  
        return Math.max(nn,pn);
        
    }
    //first occurance
    private static int bs_first(int[] arr, int x){
        int s=0, e = arr.length-1;
        int index = -1;
        while(s<=e){
            int m = s + (e-s)/2;
            if(arr[m]<x){
                index = m;
                s = m +1;
            }
            else {
                e = m - 1;
            }
        }
        return index;
        
    }
    private static int bs_last(int[] arr, int x){
        int s=0, e = arr.length-1;
        int index = -1;
        while(s<=e){
            int m = s + (e-s)/2;
            if(arr[m]<=x){
                index = m;
                s = m +1;
            }
            else {
                e = m - 1;
            }
        }
        return index+1;
        
    }
    
}

/*
arr have no number
all no in array is 0; //repetation 
all no. in array is -ve 
all no. in array is +ve 

mixed no.


*/