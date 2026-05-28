class Solution {
        public int brokenCalc(int startValue, int target) {
        int op = 0;
        while(target != startValue) {
            if(target > startValue && (target % 2 == 0)) {
                op++;
                target = target/2;
            } else {
                op++;
                target = target + 1;
            }
        }
        return op;
    }
}