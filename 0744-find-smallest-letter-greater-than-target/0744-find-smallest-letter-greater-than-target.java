class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int s = 0, e = letters.length-1;
        char ans = letters[0];
        while(s <= e) {
            int m = s + (e-s)/2;
            if(letters[m] == target) {
                s = m+1;
            } else if(letters[m] < target) {
                s = m+1;
            } else {
                ans = letters[m];
                e = m- 1;
            }
        }
        return ans;
    }
}