class Solution {
    public String sortSentence(String s) {
        String str[] = s.split(" ");
        
        String res[] = new String[str.length];
        for(String st : str) {
            char c = st.charAt(st.length()-1);
            int idx = c-'0';
            res[idx-1] = st.substring(0,st.length()-1);
        }
        String ans = "";
        for(String st : res) {
            ans += st;
            ans += " ";
        }
        return ans.substring(0, ans.length()-1);
        
    }
    private static void print(String s[]) {
        for(String st : s) {
            System.out.print(st+" ");
        }
        System.out.println();
    }
}