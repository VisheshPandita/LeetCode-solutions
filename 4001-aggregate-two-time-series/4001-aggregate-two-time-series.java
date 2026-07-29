class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        int last1 = 0;
        int last2 = 0;

        int n = series1.length-1;
        int m = series2.length-1;

        List<List<Integer>> result = new ArrayList<>();

        while(n>=0 && m>=0) {
            int current1 = series1[n][0];
            int currVal1 = series1[n][1];
            int current2 = series2[m][0];
            int currVal2 = series2[m][1];

            List<Integer> data = new ArrayList<>();
            if(current1>current2) {
                data.add(current1);
                data.add(series1[n][1] + last2);
                n--;
                last1 = currVal1;
            }else if(current1<current2) {
                data.add(current2);
                data.add(last1 + series2[m][1]);
                m--;
                last2 = currVal2;
            }else {
                data.add(current1);
                data.add(series1[n][1] + series2[m][1]);
                n--;
                m--;
                last1 = currVal1;
                last2 = currVal2;
            }

            result.add(data);
        }

        if(n>=0) {
            while(n>=0) {
                List<Integer> data = new ArrayList<>();
                data.add(series1[n][0]);
                data.add(series1[n][1] + last2);
                result.add(data);
                n--;
            }
        }

        if(m>=0) {
            while(m>=0) {
                List<Integer> data = new ArrayList<>();
                data.add(series2[m][0]);
                data.add(series2[m][1] + last1);
                result.add(data);
                m--;
            }
        }

        Collections.reverse(result);

        return result;
    }
}