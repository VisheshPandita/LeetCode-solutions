class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        int left = 0, n = products.length;

        String prefix = "";
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            left = binarySearch(products, prefix, left); 
            List<String> suggestions = new ArrayList<>();

            for (int i = left; i < Math.min(left + 3, n) && products[i].startsWith(prefix); i++) {
                suggestions.add(products[i]);
            }
            result.add(suggestions);
        }
        return result;
    }

    private int binarySearch(String[] products, String prefix, int left) {
        int right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].compareTo(prefix) >= 0) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
}