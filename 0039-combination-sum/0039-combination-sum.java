class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res.clear();
        solve(candidates, 0, 0, target, new ArrayList());
        return res;

    }
    private void solve(int arr[], int pos, int currSum, int targetSum, List<Integer> list) {
        if(currSum == targetSum) {
            res.add(new ArrayList(list));
            return;
        }
        if(pos == arr.length || currSum > targetSum) {
            return;
        }
        //not take
        solve(arr, pos+1,currSum, targetSum,list);

        // take
        list.add(arr[pos]);
        solve(arr, pos, currSum + arr[pos] , targetSum,list);
        list.remove(list.size()-1);
    }
}