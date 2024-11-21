public class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endofword = false;
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            int i = c - 'a';
            if(curr.children[i]==null){
                curr.children[i] = new TrieNode();
            }
            curr = curr.children[i];
        }
        curr.endofword = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            int i = c - 'a';
            if(curr.children[i]==null) return false;
            curr = curr.children[i];
        }
        return curr.endofword;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c: prefix.toCharArray()){
            int i = c - 'a';
            if(curr.children[i]==null) return false;
            curr = curr.children[i];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */