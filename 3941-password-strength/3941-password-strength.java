class Solution {
    public int passwordStrength(String password) {
        var set = new HashSet<Character>();
        int strength = 0;
        for(char c : password.toCharArray()) {
            if(set.contains(c)) continue;
            if(c >= 'a' && c <= 'z') strength += 1;
            else if(c >= 'A' && c <= 'Z') strength += 2;
            else if(c >= '0' && c <= '9') strength += 3;
            else strength += 5;
            set.add(c);

        }
        return strength;
    }
}