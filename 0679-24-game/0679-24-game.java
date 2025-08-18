class Solution {
    final double eps = 0.001;

    public boolean judgePoint24(int[] cards) {
         List<Double> arr = new ArrayList<>();
        for(int n: cards) arr.add((double) n);
        return solve(arr, arr.size());
        
    }
    private boolean solve(List<Double> arr, int n) {
        if(arr.size() == 1)   {
            return Math.abs(arr.get(0) - 24.0) < eps;
        }
        for(int i = 0; i <  n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j)  continue;
                double a = arr.get(i), b = arr.get(j);
                List<Double> remaining = new ArrayList<>();
                for(int k = 0; k < n; k++) {
                    if(k != i && k != j) remaining.add(arr.get(k));
                }
                List<Double> list = new ArrayList<>(Arrays.asList(
                    a+b,a-b, b-a, a*b
                ));
                if(Math.abs(b) > eps)  list.add(a/b);
                if(Math.abs(a) > eps)  list.add(b/a);
            
                for(Double d : list) {
                    remaining.add(d);
                    if(solve(remaining,remaining.size())==true)
                        return true;
                    remaining.remove(remaining.size()-1);
                }

            }
        }
        return false;
    }
}