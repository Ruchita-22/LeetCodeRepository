class Solution {
    static List<Integer> list;
    public List<Integer> lexicalOrder(int n) {
        list = new ArrayList<>();
        for(int i = 1; i <= 9; i++){
            solve(i, n);
        }
        return list;
    }
    private static void solve(int i, int n){
        if(i > n){
            return;
        }
        list.add(i);
        for(int j = 0; j < 10; j++){
            solve(10 * i + j, n);
        }
    }
}