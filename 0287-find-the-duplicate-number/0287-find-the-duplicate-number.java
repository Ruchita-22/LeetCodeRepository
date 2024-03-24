class Solution {
  
//     public int findDuplicate(int[] arr) {
//         int i=0;
//         while(i<arr.length){
//             int x = arr[i];
//             if(x == i+1)   i++; 
//             else{
//                 if(x == arr[x-1] || x == arr[x])   return x;
//                 else{ 
//                     int a = x;
//                     int b = arr[x];
//                     arr[x] = a;
//                     arr[i] = b;    
//                 }
//             }
          
//         }
//         return -1;
        
//     }
    public int findDuplicate(int[] nums) {
        
        int fast = nums[0];
        int slow = nums[0];
        slow =  nums[slow];
        fast = nums[nums[fast]];
        
        while(fast!=slow ){
            slow =  nums[slow];
            fast = nums[nums[fast]];
        }
        
        fast = nums[0];
           
        while(fast != slow ){
            slow =  nums[slow];
             fast = nums[fast];
        }
        return slow;
    }
}

/*
approach 1
sort array and check adjacent element
tc = O(nlogn)
sc = O(1)
array modified

approach 2
using hashset
tc = O(n);
sc = O(n);

approach 3 
index matching
tc=O(n)
sc=O(1)
array modified

slow and fast pointer
tc = O(n)
sc = O(1)


*/