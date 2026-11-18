class Solution {
    public String reversePrefix(String word, char c) {
        int idx = word.indexOf(c);

        int i = 0, j = idx;

        char ch[] = word.toCharArray();
        while(i < j) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;

            i++; j--;
        }
        return new String(ch);
    }
    
}