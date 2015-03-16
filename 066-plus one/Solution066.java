public class Solution066 {
    //Attempt1: 212ms
    public int[] plusOne(int[] digits) {
        int step = 1;
        int[] results = new int[digits.length];
        for (int i = digits.length - 1; i >= 0; --i) {
            int sum = digits[i] + step;
            results[i] = sum % 10;
            step = sum / 10;
        }
        if (step == 1) {
            int[] results2 = new int[digits.length + 1];
            results2[0] = 1;
            for (int i = 1; i < digits.length + 1; ++i)
                results2[i] = results[i - 1];
            return results2;
        }
        else {
            return results;
        }
    }
}
