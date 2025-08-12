class Solution {
    static List<String> res;
    static HashMap<Character, String> map;
    public List<String> letterCombinations(String digits) {

        map = new HashMap();
        map.put('0',"");
        map.put('1',"");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        res = new ArrayList<>();
        if(digits.length()==0)    return res;
        solve(0,digits,"");
        return res;

    }
    private void solve(int pos, String ip, String op) {
        if(op.length() == ip.length()) {
            res.add(new String(op));
            return;
        }
        char digit = ip.charAt(pos);
        String str = map.get(digit);
        for(int i = 0; i < str.length(); i++) {
            //op = op+str.charAt(i);
            solve(pos+1,ip, op+str.charAt(i));
        }
    }
    // private static void solve(int i,String str, String op){
    //     if(i==str.length()){
    //         res.add(op);
    //         return;
    //     }
    //     char c = str.charAt(i);
    //     String t = map.get(c);
    //     for(int j=0;j<t.length();j++){
    //         String op1 = op;
    //         op1 = op1+t.charAt(j);
    //         solve(i+1, str, op1);
    //     }

    // }
}