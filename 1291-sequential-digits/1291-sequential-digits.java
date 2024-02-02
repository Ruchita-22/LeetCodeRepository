class Solution {
    ArrayList<Integer> list;
    public List<Integer> sequentialDigits(int low, int high) {
        list = new ArrayList<>();
        for(int i = 1; i <= 9; i++){
            solve(i, i, low, high);
        }
        Collections.sort(list);
        return list;
        
        
    }
    public void solve(int num, int digit, int low, int high) {
        if(low <= num && num <= high)   list.add(num);
        if(num > high || digit >= 9)    return;
        solve((num * 10) + (digit+1), digit+1, low, high);
    }
}