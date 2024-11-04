class Solution {
    static class Pair{
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
    public int largestRectangleArea(int[] heights) {
        int area=0, n=heights.length;
        int start;
        Stack<Pair> stack = new Stack<>();
        for(int i=0;i<heights.length;i++){
            int curHt = heights[i];
            start=i;
            while(!stack.isEmpty() && stack.peek().getValue()>curHt){
                Pair pair = stack.pop();
                int index = pair.getKey();
                int h = pair.getValue();
                area = Math.max(area, h*(i-index));
                start=index;
            }
            stack.push(new Pair(start, curHt));
        }

        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            int index = pair.getKey();
            int h = pair.getValue();
            area = Math.max(area, h * (n - index));
        }

        return area;
    }
}