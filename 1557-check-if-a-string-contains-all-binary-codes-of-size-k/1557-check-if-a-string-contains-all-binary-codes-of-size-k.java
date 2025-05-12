class Solution {
    public boolean hasAllCodes(String s, int k) {
        if(s.length() < k)  return false;
        HashSet<String> set = new HashSet<>();
        int  i = 0, j = k;
        set.add(s.substring(i,j));

        while( j < s.length()) {
            i++; j++;
            set.add(s.substring(i,j));
        }
        if(set.size() == Math.pow(2,k)) return true;

        return false;


    }
}