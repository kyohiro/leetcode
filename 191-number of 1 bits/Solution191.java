public class Solution191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int val = 1, ret = 0; 
        for (int i = 0; i < 32; ++i) {
            ret += n &  val;
            val << 1;
        }

        return ret;
    }
}