class Solution {
    public List<Integer> pathInZigZagTree(int n) {
        List<Integer> ans = new ArrayList<>();
        
        ans.add(n);
        while(n > 1) {
            int l = (int) (Math.log(n)/Math.log(2));
            double llv = (int) Math.pow(2, l);
            int parent = (int)((3 * llv - n-1)/2);
            ans.add(0,parent);
            n = parent;
        }
        return ans;
    }
}

