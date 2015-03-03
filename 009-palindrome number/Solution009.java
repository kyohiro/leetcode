public class Solution009 {
    //Attempt1: 444ms
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x < 10)
            return true;

        int len = (int) Math.log10(x);
        while (len > 0) {
            int pow = (int)Math.pow(10, len);
            if (x / pow != x % 10)
                return false;
            x = (x % pow) / 10;
            len -= 2;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution009().isPalindrome(10));
    }
}
