public class Solution229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> results = new ArrayList<Integer>();
        if (nums == null || nums.length == 0)
            return results;

        int firstEle = Integer.MAX_VALUE, firstCnt = 0, secondEle = Integer.MAX_VALUE, secondCnt = 0;
        for (int i = 0 ; i < nums.length; ++i) {
            if (firstCnt == 0) {
                firstEle = nums[i];
                ++firstCnt;
            }
            else if (nums[i] == firstEle)
                ++firstCnt;
            else if (secondCnt == 0) {
                secondEle = nums[i];
                ++secondCnt;
            }
            else if (nums[i] == secondEle)
                ++secondCnt;
            else {
                --firstCnt;
                --secondCnt;
            }
        }

        firstCnt = 0;
        secondCnt = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (firstEle == nums[i])
                ++firstCnt;
            if (secondEle == nums[i])
                ++secondCnt;
        }
        if (firstCnt > nums.length / 3)
            results.add(firstEle);
        if (secondEle != firstEle && secondCnt > nums.length / 3)
            results.add(secondEle);
        return results;
    }
}