public class Solution171 {
    //Attempt1: 211ms
    public String convertToTitle(int n) {
        if (n < 27)
            return "" + (char)(n + 64);
        else
            return convertToTitle(--n / 26) + (char)(n % 26 + 65);
    }
}