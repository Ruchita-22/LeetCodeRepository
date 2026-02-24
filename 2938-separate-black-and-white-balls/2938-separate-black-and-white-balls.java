class Solution {
    public long minimumSteps(String s) {
        char ch[] = s.toCharArray();
        long swap = 0;
        int i = 0, j =  s.length()-1;

        while(i < j) {
            if(ch[i] == '0') i++;
            else if(ch[j] == '1') j--;
            else {
                swap += (j-i);
                i++; j--;
            }
        }
        //TLE
        // for (int i = 0; i <ch.length; i++) {
        //     if(ch[i] == '1') {
        //         for(int j = i+1; j < ch.length; j++) {
        //             if(ch[j] == '0') {
        //                 char t = ch[i];
        //                 ch[i] = ch[j];
        //                 ch[j] = t;
        //                 swap += (j-i);
        //                 break;
        //             }
        //         }
        //     }
        // }
        // int i = 0, j =  s.length()-1;
        // int swap = 0;
        // while(i < j) {
        //     if(s.charAt(i) == '0') i++;
        //     else if(s.charAt(j) == '1') j--;
        //     else {
        //         swap++;
        //         i++; j--;
        //     }
        // }
         return swap; 
    }
}