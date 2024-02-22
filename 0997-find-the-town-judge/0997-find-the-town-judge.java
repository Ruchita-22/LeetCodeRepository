class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n== 1 && (trust == null || trust.length == 0))    return 1;
        Set<Integer> personWhoTrustSomeone = new HashSet<>();
        Map<Integer, Integer> trustfreq = new HashMap<>();
        
        for(int i = 0; i < trust.length; i++) {
            personWhoTrustSomeone.add(trust[i][0]);
            trustfreq.put(trust[i][1], trustfreq.getOrDefault(trust[i][1],0)+1);
        }
        for(Integer t : trustfreq.keySet()) {
            if(!personWhoTrustSomeone.contains(t) && trustfreq.get(t) == n-1) return t;
        }
        return -1;
    }
}