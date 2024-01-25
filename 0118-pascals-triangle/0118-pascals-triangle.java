class Solution {
    static List<List<Integer>> lists;
    public List<List<Integer>> generate(int numRows) {
        lists = new ArrayList();
        solve(numRows);
        return lists;
    }

    private static void solve(int n) {
        if(n == 1) {
            ArrayList<Integer> temp = new ArrayList();
            temp.add(1);
            lists.add(temp);
            return;
        } 
     
        solve(n-1);
        
        List<Integer> prev = lists.get(lists.size()-1);
        List<Integer> next = new ArrayList<>();
        for(int i = 0; i <= prev.size(); i++){
            if(i == 0 || i == prev.size()) next.add(1);
            else next.add(prev.get(i-1) + prev.get(i));
            
        }
        lists.add(next);
    }
}