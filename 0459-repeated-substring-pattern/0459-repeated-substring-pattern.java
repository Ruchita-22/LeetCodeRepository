class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for(int l = s.length()/2; l>0; l--) {
            if(s.length()%l == 0) {
                int times = s.length()/l;
                StringBuilder sb = new StringBuilder();
                while(times > 0) {
                    sb.append(s.substring(0,l));
                    times--;
                }
                if(s.equals(sb.toString()))    return true;
            }
        }
        return false;
    }
}