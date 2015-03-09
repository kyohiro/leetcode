public class Solution017 {
    //Attempt1: 456ms
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; ++i) {
            int firstValue = num[i];
            int target3 = target - firstValue;
            for (int j = i + 1; j < num.length - 2; ++j) {
                int secondValue = num[j];
                int target2 = target3 - secondValue;


                int left = j + 1, right = num.length - 1;
                while (left < right) {
                    int sum = num[left] + num[right];
                    if (sum < target2)
                        ++left;
                    else if (sum > target2)
                        --right;
                    else {
                        int leftValue = num[left];
                        int rightValue = num[right];
                        results.add(Arrays.asList(new Integer[]{num[i], num[j], leftValue, rightValue}));

                        while (left < right && num[left] == leftValue)
                            ++left;
                        while (left < right && num[right] == rightValue)
                            --right;
                    }
                }
                while (j + 1 < num.length -2 && num[j + 1] == secondValue)
                    ++j;
            }
            while (i + 1 < num.length - 3 && num[i + 1] == firstValue)
                ++i;
        }

        return results;
    }

}
