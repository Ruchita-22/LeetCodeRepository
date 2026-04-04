class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0, largestCount = 0, ans = 0;
        int freq[] = new int[26];

        for(int j = 0; j < s.length(); j++) {
            char cj = s.charAt(j);
            freq[cj-'A']++;
            largestCount = Math.max(largestCount, freq[cj-'A']);

            while((j-i+1)-largestCount > k) {
                char ci = s.charAt(i);
                freq[ci-'A']--;
                i++;
            }
            ans = Math.max(ans,j-i+1);
        }
        return ans;
    }
}