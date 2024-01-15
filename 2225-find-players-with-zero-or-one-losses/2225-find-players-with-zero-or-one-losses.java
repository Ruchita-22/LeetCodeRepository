class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> loseFreq = new HashMap();
        Set<Integer> winner = new HashSet();
        for(int i = 0; i < matches.length; i++) {
            int w = matches[i][0];
            int l = matches[i][1];
            winner.add(w);
            loseFreq.put(l, loseFreq.getOrDefault(l,0)+1);
        }
        
        List<Integer> winnerList = new ArrayList();
        List<Integer> looserList = new ArrayList();
        
        for(int e : winner) {
            if(!loseFreq.containsKey(e)) winnerList.add(e);
        }
        for(int e : loseFreq.keySet()) {
            if(loseFreq.get(e) == 1)    looserList.add(e);
        }
        winnerList.sort((o1,o2) -> o1 - o2);
        looserList.sort((o1,o2) -> o1 - o2);
        return List.of(winnerList,looserList);
    }
}