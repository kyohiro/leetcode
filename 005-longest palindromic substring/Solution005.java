
public class Solution005 {
    //Attempt1: 254ms
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";

        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; ++i) {
            String palindrome = getPalindromeAround(s, i, i);
            if (palindrome.length() > longest.length())
                longest = palindrome;
            palindrome = getPalindromeAround(s, i, i + 1);
            if (palindrome.length() > longest.length())
                longest = palindrome;
        }

        return longest;
    }

    private String getPalindromeAround(String s, int l, int r) {
        if (s.charAt(l--) != s.charAt(r++))
            return "";

        while (l >= 0 && r <= s.length() - 1) {
            if (s.charAt(l) != s.charAt(r))
                break;
            else {
                --l; ++r;
            }
        }

        return s.substring(l + 1, r);
    }

    public static void main(String[] args) {
        String s = "bb";
        System.out.println(new Solution005().longestPalindrome(s));
    }
}
