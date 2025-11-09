class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        var stack = new Stack<Integer>();

        for(int i = nums2.length-1; i>= 0; i--) {
            while(stack.size() > 0 && stack.peek() <= nums2[i]) stack.pop();
            if(stack.isEmpty()) {
                map.put(nums2[i],-1);
            } else {
                map.put(nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
        }
        //System.out.println(map);
        int res[] = new int[nums1.length];
        int i = 0;
        for(int n : nums1) {
            res[i] = map.get(n);
            i++;
        }
        return res;
    }
}