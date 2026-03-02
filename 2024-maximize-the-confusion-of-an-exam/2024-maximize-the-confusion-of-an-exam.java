class Solution {
    public int maxConsecutiveAnswers(String str, int k) {
        int res = 0;
		int i = 0, j = 0;
		int freq[] = new int[2];
		//0-T and 1 - F
		while ( j < str.length()) {
			if(str.charAt(j) == 'T') freq[0]++;
			else freq[1]++;
			while(Math.min(freq[0], freq[1]) > k) {
				if(str.charAt(i) == 'T') freq[0]--;
				else freq[1]--;
				i++;
				
			}
			res = Math.max(res,j-i+1);
            j++;
		}
		
		return res;
    }
}