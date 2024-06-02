class Pair{
    char c;
    int idx;
    Pair(char c, int idx) {
        this.c = c;
        this.idx = idx;
    }
}

class Solution {
    public String clearStars(String s) {
        char ch[] = s.toCharArray();
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1,o2)-> o1.c != o2.c ? o1.c-o2.c : o2.idx - o1.idx);
        
        for(int i = 0; i < ch.length; i++){
            if(ch[i] == '*') {
                Pair p  = pq.poll();
                ch[p.idx] = '*';
            } else {
                pq.add(new Pair(ch[i], i));
            }
        }
        String res = "";
        for(char c : ch) {
            if(c != '*')
                res = res+c;
        }
        return res;
    
    }
}