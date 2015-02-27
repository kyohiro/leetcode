public class Solution006 {
    //Attempt1: 355ms
    public String convert(String s, int nRows) {
        if (s == null || s.length() == 0 || nRows < 0)
            return "";
        if (nRows == 1)
            return s;

        int offset = 2 * nRows - 2;
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < nRows; ++j) {
            for (int i = j; i < s.length(); i += offset) {
                sb.append(s.charAt(i));
                if (j != 0 && j != nRows - 1 && i + 2*nRows - 2 - 2*j < s.length())
                    sb.append(s.charAt(i + 2*nRows - 2 - 2*j));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(new Solution006().convert(s, 3));
    }
}
