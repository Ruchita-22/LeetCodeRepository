class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] arr) {
        res.clear();
        solve(arr, arr.length, 0);
        return res;

        
    }
    private void solve(int arr[], int n, int pos) {
        if(pos == n) {
            List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
            res.add(list);
            return;
        }
        for(int i = pos; i < arr.length; i++) {
            swap(arr, i, pos);
            solve(arr, n, pos+1);
            swap(arr, i, pos);
        }
    }
    private void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}