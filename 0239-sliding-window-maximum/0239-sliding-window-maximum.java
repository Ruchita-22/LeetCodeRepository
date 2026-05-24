class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        int i = 0;

        for(int j = 0; j < nums.length; j++) {

            //add nums[i]
            while(q.size() > 0 && q.peekLast() < nums[j]) {
                q.pollLast();
            }
            q.addLast(nums[j]);

            if((j-i+1) == k) {
                // calculation ans
                list.add(q.peekFirst());

                // remove nums[i]
                if(q.peekFirst() == nums[i])    q.pollFirst();
                i++;
            }
        }
        return list.stream().mapToInt(Integer :: intValue).toArray();
    }
}