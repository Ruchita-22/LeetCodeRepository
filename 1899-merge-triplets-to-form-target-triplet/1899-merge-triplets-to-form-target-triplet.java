class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int res[] = null;
       // Arrays.fill(res, -1);
        for(int arr[] : triplets){
            if(arr[0] <= target[0] && arr[1] <= target[1] && arr[2] <= target[2] ){
                if(res == null){
                    // res[0] = arr[0];
                    // res[1] = arr[1];
                    // res[2] = arr[2];
                    res = arr;

                }
                else {
                    res[0] = Math.max(res[0], arr[0]);
                    res[1] = Math.max(res[1], arr[1]);
                    res[2] = Math.max(res[2], arr[2]);
                }
            }
        }
        if(res != null && Arrays.equals(res, target))  return true;
        else return false;
        
    }
}