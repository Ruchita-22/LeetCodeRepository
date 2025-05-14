
class Solution {
    public int characterReplacement(String s, int k) {
        
        int[] arr = new int[26];
       
        int largestCount = 0, i = 0, maxlen = 0;
        
        for(int j = 0; j < s.length(); j ++){
			char ci = s.charAt(i);
			char cj = s.charAt(j);
            arr[cj - 'A']++;
            largestCount = Math.max(largestCount, arr[cj - 'A']);
            if(j - i + 1 - largestCount > k){     
                arr[ci - 'A']--;
                i ++;
            }
            maxlen = Math.max(maxlen, j - i + 1);     
        }
        return maxlen;      
    }
}