class Solution {
    public int majorityElement(int[] arr) {
        int m = arr[0], f = 1;
        for(int i = 1; i < arr.length; i++) {
            if(m == arr[i]) f++;
            else if(f > 1) f--;
            else m = arr[i];
        }
        f = 0;
        for(int e : arr) {
            if(m == e) f++;
        }
        return f >= arr.length/2 ? m : -1;
       
    }
}