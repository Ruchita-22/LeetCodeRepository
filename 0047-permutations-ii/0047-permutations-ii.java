class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] arr) {
        res.clear();
        Arrays.sort(arr);
        solve(arr, arr.length, 0);
        return res;
    }
    private void solve(int arr[], int n, int pos) {
        if(pos == n) {
            res.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
            return;
        }
        for(int i = pos; i < arr.length; i++) {
            if (!shouldSwap(arr, pos, i)) continue;
            swap(arr, i, pos);
            solve(arr, n, pos+1);
            swap(arr, i, pos);
        }
    }
    private boolean shouldSwap(int[] arr, int start, int curr) {
        for (int i = start; i < curr; i++) {
            if (arr[i] == arr[curr]) return false;
        }
        return true;
    }

    private void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/*
Backtracking = Controled Recursion + pass by reference

IBH 

 */