//https://www.youtube.com/watch?v=qVfjmkL1naw
class Solution {
    public int deleteAndEarn(int[] arr) {
        int freq[] = new int[20000];
        for(int i : arr){
            freq[i]++;
        }
        
        int incl = 0, excl = 0;
        
        for(int i = 0; i < freq.length; i++){
            int newi = excl + i * freq[i];
            int newexc = Math.max(incl, excl);
            
            incl = newi;
            excl = newexc;
        }
        return Math.max(incl, excl);
    }
}