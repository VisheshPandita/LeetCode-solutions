class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int k, int n, int start) {
        if (k == 0 && n == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (n - i < 0) {
                break;
            }
            temp.add(i);
            backtrack(result, temp, k - 1, n - i, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}