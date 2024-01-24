class Solution {
//     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
//     }
    static List<List<Integer>> lists;
    static Set<List<Integer>> set;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        lists = new ArrayList<>();
        set = new HashSet();
        solve(0,0,candidates, target, new ArrayList());
        return lists;
        
    }
    private static void solve(int i, int currSum, int[] arr, int target, ArrayList<Integer> temp) {
        if(i == arr.length) {
            if(currSum == target && !set.contains(temp)) {
                lists.add(new ArrayList(temp));
                set.add(new ArrayList(temp));
                
            }
            return;
        }
        if(currSum > target)    return;
        
        //take
        currSum += arr[i];
        temp.add(arr[i]);
        solve(i+1, currSum, arr, target, temp);
        
        // not take
        currSum -= arr[i];
        temp.remove(temp.size()-1);
        while(i+1 < arr.length && arr[i] == arr[i+1]) 
            i++;
        solve(i+1, currSum, arr, target, temp);
    }
}