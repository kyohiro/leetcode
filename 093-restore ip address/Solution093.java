public class Solution {
    //Attempt1: 300ms
    public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<String>();       
        if (s != null && s.length() != 0)
            partitionIP(s, 0, 0, "", results);

        return results;
    }

    private void partitionIP(String s, int index, int partIndex, String ip, List<String> results) {
        int remains = s.length() - index, parts = 4 - partIndex;
        if (remains > parts * 3 || remains < parts)
            return;
        else if (index == s.length() && partIndex == 4)
            results.add(ip.substring(0, ip.length() - 1));
        else {
            for (int i = index + 1; i < index + 4 && i <= s.length(); ++i) {
                int num = Integer.valueOf(s.substring(index, i));
                if (num <= 255 && (i - index == 1 || s.charAt(index) != '0')) {
                    String sip = ip + num + "." ;
                    partitionIP(s, i, partIndex + 1, sip, results);
                }
            } 
        }
    }
}