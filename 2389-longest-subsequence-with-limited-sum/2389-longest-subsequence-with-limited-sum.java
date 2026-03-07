class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        
        Arrays.sort(nums);

        int pf[] = new int[nums.length];
        pf[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            pf[i] = pf[i-1] + nums[i];
        }  

        int res[] = new int[queries.length];
        Arrays.fill(res, -1);
        
        for(int i = 0; i < queries.length; i++) {
            int target = queries[i];

            int s = 0, e = pf.length - 1;

            while (s <= e) {
                int m = s + (e - s) / 2;
                if (pf[m] == target) {
                    res[i] = m;
                    break;
                } else if (pf[m] < target) {
                    res[i] = m;
                    s = m + 1;
                } else {
                    e = m - 1;
                }
            }
        }
        // to make it 1 based 
        for(int i = 0; i < queries.length; i++) {
            res[i] = res[i]+1;
        }
        return res;
        
    }
}

