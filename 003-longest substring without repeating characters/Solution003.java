import java.util.Arrays;

public class Solution003 {

    //Attempt1: 266ms
    //DP with O(n^2) time complexity
    //Always trace back to the starting char of the current longest substring
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int startingIndex = 0, longest = 1;
        for (int i = 1; i < s.length(); ++i) {
            char currentValue = s.charAt(i);
            for (int j = i - 1; j >= startingIndex; --j) {
                if (s.charAt(j) == currentValue) {
                    int newLen = i - j;
                    longest = longest >= newLen ? longest : newLen;
                    startingIndex = j + 1;
                    break;
                }
                else if (j == startingIndex) {
                    int newLen = i - j + 1;
                    longest = longest >= newLen ? longest : newLen;
                }
            }
        }

        return longest;
    }

    //Attempt2: 240ms
    //DP with O(n) time complexity
    //plus a constant size array to keep track of last appearing index of all ASCII characters
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int startingIndex = 0, longest = 0;
        int[] lastVisited = new int[256];
        Arrays.fill(lastVisited, -1);

        for (int idx = 0; idx < s.length(); ++idx) {
            char currentValue = s.charAt(idx);
            int lastIndex = lastVisited[(int)currentValue];
            if (lastIndex >= startingIndex) {
                int newLen = idx - startingIndex;
                longest = longest >= newLen ? longest : newLen;
                startingIndex = lastIndex + 1;
            }
            lastVisited[(int)currentValue] = idx;
        }
        return longest >= s.length() - startingIndex ? longest : s.length() - startingIndex;
    }

    public static void main(String[] args) {
        String s = "aabcdasdfba";
        System.out.println(new Solution003().lengthOfLongestSubstring2(s));
    }

}
