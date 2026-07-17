class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;
        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(id);
        visited[id] = true;

        for(int l=0; l<level; l++){
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int person = queue.poll();
                for(int friend: friends[person]) {
                    if(!visited[friend]) {
                        visited[friend] = true;
                        queue.offer(friend);
                    }
                }
            }
        }

        Map<String, Integer> freq = new HashMap<>();
        for(int person: queue) {
            for(String video: watchedVideos.get(person)) {
                if(freq.containsKey(video)) {
                    freq.put(video, freq.get(video)+1);
                }else {
                    freq.put(video, 1);
                }
            }
        }

        List<String> result = new ArrayList<>(freq.keySet());
        result.sort((a, b) -> {
            int fa = freq.get(a);
            int fb = freq.get(b);

            if(fa!=fb) {
                return Integer.compare(fa, fb);
            }

            return a.compareTo(b);
        });

        return result;
    }
}