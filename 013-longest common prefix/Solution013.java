public class Solution013 {
    //Attempt1: 317ms
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs[0].length() == 0)
            return "";

        String prefix = "";
        for (int i = 0; i < strs[0].length(); ++i) {
            char crt = strs[0].charAt(i);
            for (int j = 1; j < strs.length; ++j) {
                if (strs[j].length() <= i || strs[j].charAt(i) != crt)
                    return prefix;
            }

            prefix += crt;
        }

        return prefix;
    }
}
