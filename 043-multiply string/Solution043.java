public class Solution043 {
    //Attempt1: 337ms
    public String multiply(String num1, String num2) {
        int l1 = num1.length(), l2 = num2.length(); 
        if (l1 == 0 && l2 == 0)
            return "0";
        else if (l1 == 0)
            return num2;
        else if (l2 == 0)
            return num1;
        else if (l1 < l2)
            return multiply(num2, num1);

        Map<Character, String> map = simpleMultiplyMap(num1);
        String ret = "";

        for (int i = 0; i < l2; ++i) {
            ret += "0";
            ret = add(ret, map.get(num2.charAt(i))); 
        }
        return ret;
    }

    private String add(String num1, String num2) {
        String ret = "";
        int step = 0, i = num1.length() - 1, j = num2.length() - 1;
        for (; i >= 0 || j >= 0; --i, --j) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = x + y + step;
            step = sum / 10;
            ret = String.valueOf(sum % 10) + ret;
        }

        return step == 1 ? "1" + ret : ret;
    }

    private Map<Character, String> simpleMultiplyMap(String base) {
        String ret = "0";
        Map<Character, String> map = new HashMap<Character, String>();
        map.put('0', ret);
        for (int i = 1; i <= 9; ++i) {
            ret = add(ret, base);
            map.put((char)(i + '0'), ret);
        }
        return map;
    }
}