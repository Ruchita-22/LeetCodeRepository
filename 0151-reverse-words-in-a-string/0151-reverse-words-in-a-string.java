
class Solution {

    public String reverseWords(String s) {

        char[] ch = s.toCharArray();

        // Step 1: Remove leading, trailing and multiple spaces
        int n = removeExtraSpaces(ch);

        // Step 2: Reverse the entire string
        reverseStringInRange(ch, 0, n - 1);

        // Step 3: Reverse each individual word
        int i = 0;

        for (int j = 0; j < n; j++) {

            if (ch[j] == ' ') {
                reverseStringInRange(ch, i, j - 1);
                i = j + 1;
            }
        }

        // Reverse the last word
        reverseStringInRange(ch, i, n - 1);

        return new String(ch, 0, n);
    }

    // Removes leading, trailing and multiple spaces in-place
    public int removeExtraSpaces(char[] ch) {

        int i = 0, j = 0;
        int n = ch.length;

        while (i < n) {

            // Skip leading and multiple spaces
            while (i < n && ch[i] == ' ') {
                i++;
            }

            // Copy current word
            while (i < n && ch[i] != ' ') {
                ch[j++] = ch[i++];
            }

            // Skip spaces after current word
            while (i < n && ch[i] == ' ') {
                i++;
            }

            // Add one space only between words
            if (i < n) {
                ch[j++] = ' ';
            }
        }

        return j;
    }

    // Reverses characters between given indices
    public void reverseStringInRange(char[] ch, int i, int j) {

        while (i < j) {

            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;

            i++;
            j--;
        }
    }
}
