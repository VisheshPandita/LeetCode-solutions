class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>(
            (a,b) -> Double.compare(b[0], a[0])
        );

        for(int i=0;i<classes.length;i++){
            int passed = classes[i][0];
            int total = classes[i][1];
            double gain = calculateGain(passed, total);
            maxHeap.offer(new double[]{gain, passed, total});
        }

        while(extraStudents>0){
            double[] top = maxHeap.poll();
            int passed = (int) top[1];
            int total = (int) top[2];

            passed++;
            total++;

            double newGain = calculateGain(passed, total);
            maxHeap.offer(new double[]{newGain, passed, total});

            extraStudents--;
        }

        double totalRatio = 0.0;
        while(!maxHeap.isEmpty()){
            double[] top = maxHeap.poll();
            int passed = (int) top[1];
            int total = (int) top[2];
            totalRatio += (double) passed / total;
        }

        return totalRatio / classes.length;
    }

    private double calculateGain(int passed, int total) {
        double calRatio = (double) passed/total;
        double newRatio = (double) (passed+1)/(total+1);
        return newRatio-calRatio;
    }
}