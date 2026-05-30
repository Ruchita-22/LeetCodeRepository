class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String s1[] = sentence1.split(" ");
        String s2[] = sentence2.split(" ");


        if(s1.length < s2.length) {
            String s[] = s1;
            s1 = s2;
            s2 = s;
        }
        // print(s1);
        // print(s2);
        int i = 0, j = s1.length-1, k = 0, l = s2.length-1;
        while(k <= l) {
            if(s2[k].equals(s1[i])) {
                i++; k++;
            } else if(s2[l].equals(s1[j])) {
                j--; l--;
            } else {
                return false;
            }
        }

        return true;

    }
    void print(String s[]) {
        for(String st : s) {
            System.out.print(st+" ");
        }
        System.out.println();
    }
}