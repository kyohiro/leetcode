public class Solution190 {
    // you need treat n as an unsigned value
    //Attempt1: 336ms
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; ++i) {
            result = (result << 1) + (n & 1);
            n >>= 1;
        }
        return result;
    }
}