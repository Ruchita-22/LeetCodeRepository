//https://www.youtube.com/watch?v=iOqH_JnXIOQ
class Solution {
    public int maxFrequency(int[] arr, int k) {
        Arrays.sort(arr);
        
        int n = arr.length;
        
        int result = 0;
        
        int i = 0, j = 0;
        long currSum = 0;
		
        
        while( j < n) {
            
            long target = arr[j];
            currSum += arr[j];
			long op = (j - i + 1) * target - currSum;
            
            while (op > k) {
                currSum -= arr[i];
                i++;
				op = (j - i + 1) * target - currSum;
            }
            
            result = Math.max(result, j - i + 1);
			j++;
            
        }
        return result;
    }
}
/*
operation allowed = atmost k times
operation = arr[i] + 1


max possible freq




*/