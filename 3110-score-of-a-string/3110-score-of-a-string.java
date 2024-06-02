class Solution {
    public int scoreOfString(String s) {
        char prev = s.charAt(0);
        int score = 0;
        for(int i = 1; i < s.length(); i++) {
            score += Math.abs(prev-s.charAt(i));
            prev = s.charAt(i);
        }
        return score;
    }
}