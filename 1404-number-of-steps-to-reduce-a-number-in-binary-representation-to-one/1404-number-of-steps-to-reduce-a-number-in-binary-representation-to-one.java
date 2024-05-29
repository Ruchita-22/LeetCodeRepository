class Solution {
    public int numSteps(String s) {
        int op = 0, carry = 0;
        
        for(int n = s.length()-1; n > 0 ; n--){
            if( ((s.charAt(n)-'0') + carry) % 2 == 1) {
                carry = 1;
                op += 2;
                
            } else op += 1;
        }
        return op+carry;
    }
}