class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<int[]> robots = new ArrayList<>();
        for(int i = 0; i < positions.length; i++) {
            robots.add(new int[] {positions[i],healths[i],directions.charAt(i), i});
        }
        //print1(robots);
        Collections.sort(robots,(a,b)->a[0]-b[0]);
        //print1(robots);
        Stack<int[]> stack = new Stack<>();
        for(int[] robot : robots) {
            if(stack.isEmpty() || stack.peek()[2] == 'L' || robot[2] == 'R') { // no collsion 
                stack.push(robot);
                continue;
            }
            if(robot[2] == 'L') {
                boolean robotAlive = true;
                while(!stack.isEmpty() && stack.peek()[2] == 'R' && robotAlive) {
                    if(robot[1] > stack.peek()[1]) {
                        stack.pop();
                        robot[1] = robot[1] - 1;
                        robotAlive = true;
                    } else if(robot[1] < stack.peek()[1]) {
                        stack.peek()[1] = stack.peek()[1] -1;
                        robotAlive = false;
                    } else {    // if equal health
                        stack.pop();
                        robotAlive = false;
                    }
                }
                if(robotAlive) {
                    stack.push(robot);
                }
            }
            
        }
        List<int[]> list = new ArrayList<>(stack);
        //print1(list);
        list.sort(Comparator.comparingInt(a -> a[3]));
        //print1(list);
        List<Integer> res = new ArrayList();
        for(int[] robot : list) {
            res.add(robot[1]);
        }
        return res;
    }
    private void print1(List<int[]> arrs) {
        for(int[] arr : arrs) {
            System.out.print("["+ arr[0] +","+ arr[1] +","+ arr[2] +","+ arr[3]+"] ");
        }
        System.out.println();
    }
}