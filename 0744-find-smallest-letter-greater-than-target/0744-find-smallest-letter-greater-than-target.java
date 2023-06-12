class Solution {
    public char nextGreatestLetter(char[] arr, char target) {
        
        int s=0,e=arr.length-1;
        int idx = -1;
        while(s<=e){
            int m = s+(e-s)/2;
            if(arr[m]> target){
                idx = m;
                e = m-1;
            }
            else
                s = m + 1;
        }
        return idx == -1 ? arr[0] : arr[idx];
    }
}