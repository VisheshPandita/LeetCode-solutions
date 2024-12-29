class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null || envelopes.length==0) return 0;

        // Sort envelops on width
        Arrays.sort(envelopes, (a,b) -> {
            if(a[0]==b[0]) return b[1]-a[1];
            return a[0]-b[0];
        });

        // Extract the heights
        int[] heights = new int[envelopes.length];
        for(int i=0;i<envelopes.length;i++){
            heights[i] = envelopes[i][1];
        }

        // Find LIS on heights
        return lengthOfLIS(heights);
    }

    private int lengthOfLIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();

        for (int num : nums) {
            int pos = Collections.binarySearch(lis, num);
            if (pos < 0) {
                pos = -(pos + 1);
            }
            if (pos < lis.size()) {
                lis.set(pos, num); // Replace element
            } else {
                lis.add(num); // Add new element
            }
        }

        return lis.size();
    }
}