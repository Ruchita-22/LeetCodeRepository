//https://www.youtube.com/watch?v=IOOFHFXenQU&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=26
class Solution {

    public int longestSubsequence(int[] arr, int diff) {
        int n = arr.length;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		int ans=0;

		for(int i=0;i<arr.length;i++) {
			int temp = arr[i] - diff;
			int tempAns = 0;
			if(map.containsKey(temp))	tempAns = map.get(temp);
			map.put(arr[i], 1 + tempAns);
			ans = Math.max(ans, map.get(arr[i]));
		}
		
		return ans;	
    }
}