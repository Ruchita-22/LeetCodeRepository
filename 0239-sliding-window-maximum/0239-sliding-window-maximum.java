class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque();
        List<Integer> res = new ArrayList();

        int i = 0;
        for(int j = 0; j < nums.length; j++) {
            while(q.size() > 0 && q.peekLast() < nums[j])   q.pollLast();
            q.addLast(nums[j]);

            if(j-i+1 == k) {
                res.add(q.peekFirst());

                if(q.peekFirst() == nums[i]) q.pollFirst();
                i++;
            }

        }
        return res.stream().mapToInt(Integer :: intValue).toArray();
        
    }

    
}