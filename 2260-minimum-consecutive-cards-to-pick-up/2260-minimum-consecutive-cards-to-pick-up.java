class Solution {
    public int minimumCardPickup(int[] cards) {
        if(cards == null || cards.length == 0)   return -1;
        
        int i = 0,  j = 0, ws = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet();
        
        while(j < cards.length) {
            
            if(!set.contains(cards[j])) {
                set.add(cards[j]); 
                j++;
            } else {
                ws = Math.min(ws, j-i+1);
                while(set.contains(cards[j])) {
                    set.remove(cards[i]); 
                    i++;
                }
                ws = Math.min(ws, j-i+2);
            }
            
        }
        // ws = Math.min(ws, set.size()+1);
         return set.size() == cards.length ? -1 : ws;             
    }
}