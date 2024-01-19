class Solution {
    public int longestBeautifulSubstring(String word) {
        char vowels[] = {'a', 'e', 'i', 'o', 'u'};
        
        int i = 0, j = 0;
        int currentVowel = 0;
        int ans=0;
        
        while(j < word.length()) {
            
            if(word.charAt(j) == vowels[currentVowel])  j++;
            else if(j>0 && currentVowel+1<vowels.length && word.charAt(j)==vowels[currentVowel+1] && word.charAt(j-1)==vowels[currentVowel]) {
                j++;
                currentVowel++;
            } else { // pattern stopped
                if(currentVowel==4)
                {
                    ans=Math.max(ans,j-i);
                }
                currentVowel=0;
                i=j;
                if(word.charAt(j)==vowels[currentVowel])
                {
                    j++;
                } else {
                    i++; j++;
                }
            }
        }
        if(currentVowel==4)
        {
            ans=Math.max(ans,j-i);
        }
        return ans;        
    }
}