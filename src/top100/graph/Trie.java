package top100.graph;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/3/9 20:14
 */
public class Trie {

    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (char ch : word.toCharArray()){
            if (node.children[ch -'a'] == null)
                node.children[ch -'a'] = new Trie();
            node = node.children[ch -'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = this;
        for (char ch : word.toCharArray()){
            if (node.children[ch -'a'] == null)
                return false;
            node = node.children[ch -'a'];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie node = this;
        for (char ch : prefix.toCharArray()){
            if (node.children[ch -'a'] == null)
                return false;
            node = node.children[ch -'a'];
        }
        return true;
    }
}
