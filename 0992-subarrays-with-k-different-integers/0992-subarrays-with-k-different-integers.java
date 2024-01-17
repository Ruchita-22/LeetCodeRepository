class Solution {
    public int atMostK(int[]nums,int k)
    {   //System.out.println(k);
        if(k == 0)  return 0;
        HashMap<Integer,Integer> freq=new HashMap<>();
        int j=0; // ending point
        int n=nums.length;

        // we are going on each starting point and checking what is the maximum ending point we can have 

        int ans=0;

        for(int i=0;i<n;i++) //  starting point
        {   
            while(j<n)
            {   
                if(freq.size() == k && freq.containsKey(nums[j]) == false)
                {
                    //j--;
                    break;
                }
                else
                {
                    freq.put(nums[j],freq.getOrDefault(nums[j],0)+1);
                    j++;
                }
            
            }
            //System.out.println(i + " "+ j+ " "+ freq);
            
            
            ans += j-i;
            if(freq.get(nums[i])>1)
                freq.put(nums[i],freq.get(nums[i])-1);
            else
                freq.remove(nums[i]);

        }
        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums,k)-atMostK(nums,k-1);
    }
}