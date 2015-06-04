public class Solution120 {
    //Attempt1: Timeout with recursion
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)        
            return 0;
        return subMin(triangle, 1, 0, triangle.get(0).get(0));
    }

    private int subMin(List<List<Integer>> triangle, int level, int pos, int sum) {
        if (level == triangle.size())
            return sum;

        List<Integer> array = triangle.get(level);
        int min = subMin(triangle, level + 1, pos, sum + array.get(pos));
        if (pos - 1 >= 0) {
            int left = subMin(triangle, level + 1, pos - 1, sum + array.get(pos - 1));
            min = left < min ? left : min;
        }
        if (pos + 1 < array.size()) {
            int right = subMin(triangle, level + 1, pos + 1, sum + array.get(pos + 1));
            min = right < min ? right : min;
        }

        return min;
    }

    //Attempt2: DP with O(n) space
    public minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) 
            return 0;
        else if (triangle.size() == 1)
            return triangle.get(0).get(0);

        int[] levelMax = new int[triangle.size()];
        levelMax[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); ++i) {
            List<Integer> level = triangle.get(i);
            int j = i;
            levelMax[j] = levelMax[j - 1] + level.get(j);
            while (--j > 0)
                levelMax[j] = Math.min(levelMax[j - 1], levelMax[j]) + level.get(j);

            levelMax[0] += level.get(0);
        }

        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < levelMax.length; ++i) {
            if (levelMax[i] < ret)
                ret = levelMax[i];
        }
        return ret;
    }

}