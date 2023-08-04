class Solution {
    static List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        int arr[] = new int[n];
        for(int i=0;i<n;i++)    arr[i] = i+1;
        res = new ArrayList<>();
        solve(0,0,arr,k,new ArrayList<>());
        return res;
    }
    private static void solve(int i,int f, int arr[],int k, List<Integer> temp){
        if(f>k) return ;
        if(i==arr.length){
            List<Integer> t = new ArrayList<>(temp);
            if(f==k){
                res.add(t);
            }
            return;
        }

        temp.add(arr[i]);
        f++;
        solve(i+1, f, arr, k, temp);

        temp.remove(temp.size()-1);
        f--;
        solve(i+1, f, arr, k, temp);
    }
}