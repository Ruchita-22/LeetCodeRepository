class Solution {
    public boolean checkGoodInteger(int n) {
       
        long digitSum = 0, squareSum = 0;

        while(n > 0) {
            int a = n%10;
            n = n/10;
            digitSum += a;
            squareSum += (a*a);
        }

        return (squareSum - digitSum) >= 50 ;
        
    }
}