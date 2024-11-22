class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);

        for(int i=0;i<queries.length;i++){
            int size=Integer.MAX_VALUE;
            for(int j=0;j<intervals.length;j++){
                if(queries[i]>=intervals[j][0] && queries[i]<=intervals[j][1]){
                    size = Math.min(size, intervals[j][1] - intervals[j][0] + 1);
                }
            }
            
            if(size!=Integer.MAX_VALUE) ans[i] = size;
        }

        return ans;
    }
}