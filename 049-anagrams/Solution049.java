public class Solution049 {
    //Attempt1: 567ms
    public List<String> anagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            String sorted = sortStr(s);
            if (!map.containsKey(sorted))
                map.put(sorted, new ArrayList<String>());
            map.get(sorted).add(s);
        }
        
        List<String> results = new ArrayList<String>();
        for (String s : map.keySet()) {
            if (map.get(s).size() > 1)
                results.addAll(map.get(s));
        }
        
        return results;
    }
    
    private String sortStr(String str) {
        char[] cs = str.toCharArray();
        Arrays.sort(cs);
        return new String(cs);
    }
}