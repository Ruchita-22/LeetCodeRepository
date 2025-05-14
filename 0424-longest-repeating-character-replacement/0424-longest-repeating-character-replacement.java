
class Solution {
    public int characterReplacement(String s, int k) {
        
        int[] arr = new int[26];
        int largestCount = 0, i = 0, j = 0, maxlen = 0;
        
        while ( j < s.length()){
			char cj = s.charAt(j);
            arr[cj - 'A']++;
            largestCount = Math.max(largestCount, arr[cj - 'A']);
            
            if((j - i + 1) - largestCount > k){   
                char ci = s.charAt(i);  
                arr[ci - 'A']--;
                i++;
            }
            maxlen = Math.max(maxlen, j - i + 1);  
            j++;   
        }
        return maxlen;      
    }
}