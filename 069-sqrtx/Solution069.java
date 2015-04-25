public class Solution069 {
    //Attempt1: 250ms
    public int mySqrt(int x) {
        if (x < 0)
            return -1;
        
        long left = 0, right = x / 2 + 1;
        while (left <= right) {
            long mid = left + (right - left) / 2 ;
            long sqr = mid * mid;
            if (sqr > x)
                right = mid - 1;
            else if (sqr < x)
                left = mid + 1;
            else
                return (int)mid;
        }
        
        return (int)((left + right) / 2);
    }
}