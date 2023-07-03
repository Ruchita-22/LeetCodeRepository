class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length())    return false;
        
        if(A.equals(B)){
            HashSet<Character> set = new HashSet<>();
            for(char ch : A.toCharArray()){
                if(set.contains(ch))    return true;
                set.add(ch);
            }
            return false;
        }
        else{
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < A.length(); i++){
                if(A.charAt(i) != B.charAt(i))
                    list.add(i);
            }
            if(list.size()==2 && 
               A.charAt(list.get(0)) == B.charAt(list.get(1)) &&
               B.charAt(list.get(0)) == A.charAt(list.get(1))
              )  return true;
            return false;
        }
        
    }
}