class Solution {
    public String maximumOddBinaryNumber(String s) {
        int count = 0;
        for(char c : s.toCharArray()) {
            if(c == '1') count++;
        }
        
        if(count == 0)  return s;
        
        
        int c0 = s.length() - count;
        int c1 = count-1;
        StringBuilder s0 = new StringBuilder();
        StringBuilder s1 = new StringBuilder();
        
        while(c0 > 0) {
            s0.append('0');
            c0--;
        }
        while(c1 > 0) {
            s1.append('1');
            c1--;
        }
        s1 = s1.append(s0);
        s1 = s1.append('1');
        return new String(s1);
        
    }
}