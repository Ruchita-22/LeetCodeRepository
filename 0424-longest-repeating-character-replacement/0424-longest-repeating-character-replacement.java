class Solution {
    public int characterReplacement(String s, int k) {
        
        int[] arr = new int[26];
       
        int largestCount = 0, i = 0, maxlen = 0;
        
        for(int j = 0; j < s.length(); j ++){
            arr[s.charAt(j) - 'A']++;
            largestCount = Math.max(largestCount, arr[s.charAt(j) - 'A']);
            if(j - i + 1 - largestCount > k){     
                arr[s.charAt(i) - 'A']--;
                i ++;
            }
            maxlen = Math.max(maxlen, j - i + 1);     
        }
        return maxlen;      
    }
}