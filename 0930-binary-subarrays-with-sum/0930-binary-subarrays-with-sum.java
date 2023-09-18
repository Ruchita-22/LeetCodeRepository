class Solution {
    public int numSubarraysWithSum(int[] arr, int goal) {
        return countSubArrayWithSumK(arr, arr.length, goal);
    }
    private static int countSubArrayWithSumK(int arr[], int n, int k)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int sum = 0;
        int j=0;
        while (j < n) {
            sum += arr[j];
            int removeSum=sum-k;
            if (map.containsKey(removeSum))
            	count += map.get(removeSum);
            map.put(sum,map.getOrDefault(sum,0)+1);
            j++;
        }
 
        return count;
    }
}