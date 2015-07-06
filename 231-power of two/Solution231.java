public class Solution231 {
    public boolean isPowerOfTwo(int n) {
        while (n != 0 && (n & 1) == 0) 
            n = n >> 1;
        return n == 1;
    }
}