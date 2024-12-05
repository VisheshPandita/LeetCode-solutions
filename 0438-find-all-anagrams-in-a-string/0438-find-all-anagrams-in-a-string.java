class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p.length()>s.length()) return result;

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for(char i: p.toCharArray()){
            pCount[i-'a']++;
        }

        for(int i=0;i<s.length();i++){
            // add the char
            sCount[s.charAt(i)-'a']++;

            // remove extra char from window
            if(i>=p.length()){
                sCount[s.charAt(i-p.length()) - 'a']--;
            }

            // check if pCount is equal to sCount
            if(Arrays.equals(pCount, sCount)){
                result.add(i-p.length()+1);
            }
        }

        return result;
    }
}