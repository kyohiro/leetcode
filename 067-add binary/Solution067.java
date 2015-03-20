public class Solution067 {
    //Attempt1: 252ms
    public String addBinary(String a, String b) {
        if (a.length() == 0)
            return b;
        if (b.length() == 0)
            return a;
        
        int lenA = a.length() - 1, lenB = b.length() - 1;
        int step = 0;
        String ret = "";
        while (lenA >=0 && lenB >= 0) {
            int sum = Character.getNumericValue(a.charAt(lenA--)) + Character.getNumericValue(b.charAt(lenB--)) + step;
            step = sum / 2;
            ret = String.valueOf(sum % 2) + ret;
        }
        while (lenA >= 0) {
            int sum = Character.getNumericValue(a.charAt(lenA--)) + step;
            step = sum / 2;
            ret = String.valueOf(sum % 2) + ret;
        }
        while (lenB >= 0) {
            int sum = Character.getNumericValue(b.charAt(lenB--)) + step;
            step = sum / 2; 
            ret = String.valueOf(sum % 2) + ret;
        }
        if (step == 1)
            ret = String.valueOf(1) + ret;

        return ret;
    }
}