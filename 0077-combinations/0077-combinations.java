class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        res.clear();
        solve(n, k, 0, new ArrayList(2));
        return res;
    }
    private void solve(int n, int k, int pos, List<Integer> list) {

        if(pos == k) {
            res.add(new ArrayList(list));
            return;
        }

        for(int i = 1 ; i <= n; i++) {
            if(list.size() > 0 && i <= list.get(list.size()-1)) continue; 
            list.add(pos,i);
            solve(n, k, pos+1, list);
            list.remove(list.size()-1);
        }
    }
}