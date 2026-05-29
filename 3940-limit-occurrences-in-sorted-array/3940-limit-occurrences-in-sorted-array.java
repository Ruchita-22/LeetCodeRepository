class Solution {
    public int[] limitOccurrences(int[] nums, int k) {

        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        int j = 1, count = 1, prev = nums[0];
        while(j < nums.length) {
            if(prev == nums[j]) {
                if(count < k) {
                    list.add(nums[j]);
                    count++;
                }
            } else {
                count = 1;
                list.add(nums[j]);
                prev = nums[j];
            }
            j++;

        }
        return list.stream().mapToInt(Integer :: intValue).toArray();
        
    }
}