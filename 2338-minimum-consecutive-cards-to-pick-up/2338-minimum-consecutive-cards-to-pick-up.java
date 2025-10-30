class Solution {
    public int minimumCardPickup(int[] cards) {
        
        var set  = new HashSet<Integer>();
        int i = 0, j = 0;
        int ws = Integer.MAX_VALUE;

        while(j < cards.length) {
            if(set.contains(cards[j])) {
                ws = Math.min(ws, j-i+1);
                while(set.contains(cards[j])) {
                    set.remove(cards[i]);
                    i++;
                    if(set.contains(cards[j])) ws = Math.min(ws, j-i+1);
                }
            }
            set.add(cards[j]);
            j++;
        }
        return ws == Integer.MAX_VALUE ? -1 : ws;

    }
}