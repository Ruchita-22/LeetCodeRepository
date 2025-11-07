class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        var stack = new Stack<Integer>();

        for (int num : asteroids) {
            //when collision happen 
            while(num < 0 && stack.size() > 0 && stack.peek() > 0) {
                int sum = stack.peek() + num;
                if(sum < 0) {
                    stack.pop();
                } else if(sum == 0) {
                    stack.pop();
                    num = 0;
                } else {
                    num = 0;
                }
            }
            if(num != 0) {
                stack.push(num);
            }
           
        }
        return stack.stream().mapToInt(Integer :: intValue).toArray();
        
    }
}