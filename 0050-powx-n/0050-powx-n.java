class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        if(x == 1)  return 1.0;
        if(n < 0)   return 1.0/myPow(x,-n);

        double pow = myPow(x, n/2);
        pow = pow * pow;
        if (n % 2 == 0)
            return pow;
        else 
            return pow * x;    
            
    }
}