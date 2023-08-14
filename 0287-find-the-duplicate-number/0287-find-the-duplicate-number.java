class Solution {
    public int findDuplicate(int[] arr) {
        int i=0;
        while(i<arr.length){
            int x = arr[i];
            if(x == i+1)   i++; 
            else{
                if(arr[x-1]==x)   return x;
                else if(x == arr[x])   return arr[i];
                else{
                    // if(x == arr[x])   return arr[i];
                    
                    int a = x;
                    int b = arr[x];
                    arr[x] = a;
                    arr[i] = b;    
                }
            }
          
        }
        return -1;
        
    }
}


/*
- no repeattaion of elements
-
n+1 = 5 
    1-4
    
arr = 1 2 3 4
    
 num =   1 3 4 2 2  
 n+1 =5
 1-5
    
    =2
    
    x^x = 0
    0^x = x
    
    Tc = O(n)
    
    sorting = nlog + n = nlog n 
        sc = O(1); 
        
    hashset  = n 
    sc = n
    
    xor = 
    
    
    
    
 */   