public class Solution179 {
    //Attempt1: 393ms
    public String largestNumber(int[] nums) {
        String[] numsInString = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            numsInString[i] = String.valueOf(nums[i]);
        } 

        Arrays.sort(numsInString, new Comparator<String>() {
            public int compare(String left, String right) {
                String lr = left.concat(right);
                String rl = right.concat(left);
                return rl.compareTo(lr);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numsInString.length; ++i)
            sb.append(numsInString[i]);

        java.math.BigInteger i = new java.math.BigInteger(sb.toString());
        return i.toString();
    }
}