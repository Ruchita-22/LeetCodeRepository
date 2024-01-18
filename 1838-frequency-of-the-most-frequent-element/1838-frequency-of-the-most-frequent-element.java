//https://www.youtube.com/watch?v=iOqH_JnXIOQ
class Solution {
    public int maxFrequency(int[] arr, int k) {
        Arrays.sort(arr);
        
        int result = 0;
        
        int i = 0, j = 0;
        long currSum = 0;
		
        while( j < arr.length) {
            
            long windowSum = (j - i + 1) * 1L * arr[j];
			
            currSum += arr[j];
			long op = windowSum - currSum;
            
            while (op > k && i<j) {
                currSum -= arr[i];
                i++;
                windowSum = (j - i + 1) * 1L * arr[j];
				op = windowSum - currSum;
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