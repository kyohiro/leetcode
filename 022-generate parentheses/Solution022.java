public Solution022 {
    //Attempt1: 214ms
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<String>();
        if (n > 0)
            addParenthesis(n, n, "", ret);
        return ret;
    }

    private void addParenthesis(int left, int right, String item, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(item);
            return;
        }
        else if (left < right && right > 0)
            addParenthesis(left, right - 1, item + ")", result);
        if (left > 0)
            addParenthesis(left - 1, right, item + "(", result);
    }
}