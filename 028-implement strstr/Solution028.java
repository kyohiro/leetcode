public class Solution028 {
    //Attempt1: 296ms
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length(), len2 = needle.length();
        if (len1 < len2)
            return -1;
        else if (len2 == 0)
            return 0;

        for (int i = 0; i <= len1 - len2; ++i) {
            int j = 0;
            while (j < len2 && haystack.charAt(i + j) == needle.charAt(j))
                ++j;
            if (j == len2)
                return i;
        }

        return -1;
    }
}
