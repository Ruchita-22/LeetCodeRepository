class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        if(tokens == null || tokens.length == 0 || power == 0) return 0;
        Arrays.sort(tokens);
        // for(int e : tokens) System.out.println(e + " ");
        // System.out.println();
        if(tokens[0] > power) return 0;
        
        int score = 0, maxAns = 0;
        int i = 0, j = tokens.length-1;
        while(i <= j) {
            if(tokens[i] <= power) {
                score++;
                maxAns = Math.max(maxAns, score);
                power -= tokens[i];
                i++;
            } else {
                score--;
                power += tokens[j];
                j--;   
            }
        }
        return maxAns;
        
    }
}