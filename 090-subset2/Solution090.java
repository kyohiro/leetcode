public class Solution090 {
    //Attempt1: 356ms
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();    
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        subSubsets(nums, 0, list, results);

        return results;
    }
    
    private void subSubsets(int[] nums, int s, List<Integer> list, List<List<Integer>> results) {
        results.add(new ArrayList<Integer>(list));

        for (int i = s; i < nums.length; ++i) {
            if (i == s || nums[i] != nums[i - 1]) {
                list.add(nums[i]);
                subSubsets(nums, i + 1, list, results);
                list.remove(list.size() - 1);
            }
        }
    }
}