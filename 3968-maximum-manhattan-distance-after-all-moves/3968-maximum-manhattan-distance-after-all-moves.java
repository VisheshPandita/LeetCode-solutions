class Solution {
    public int maxDistance(String moves) {
        char[] data = moves.toCharArray();
        int h=0;
        int v=0;
        int temp=0;
        for(int i=0; i<data.length;i++){
            if(data[i] == 'U') v++;
            else if(data[i] == 'D') v--;
            else if(data[i] == 'R') h++;
            else if(data[i] == 'L') h--;
            else if(data[i] == '_') {
                temp++;
            }
        }

        return Math.abs(v) + Math.abs(h) + temp;
    }
}