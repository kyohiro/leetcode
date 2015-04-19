public class Solution050 {
    //Attempt1: 398ms
    public double pow(double x, int n) {
        if (n == 0)
            return 1;
        else if (x == 1)
            return 1;
        else if (x == -1)
            return n % 2 == 0 ? 1 : -1;
        else if (n < 0)
            return pow(1 / x, -1 * n);
            
        double p = pow(x, n / 2);
        if (n % 2 == 0)
            return p * p;
        else
            return x * p * p;
    }
}