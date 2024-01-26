class Solution {
    static List<String> list;
    public List<String> generateParenthesis(int n) {
        list = new ArrayList();
        
        solve(0,0,"", n);
        return list;
    }
    private static void solve(int ob, int cb, String s, int n) {
        if(ob == n && cb == n){
            list.add(new String(s));
            return;
        }
        if(ob < n)
            solve(ob+1, cb, s+'(', n);
        if(cb < ob)
            solve(ob, cb+1, s+')', n);
        
    }
}