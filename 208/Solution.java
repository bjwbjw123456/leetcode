class TrieNode {
    // Initialize your data structure here.
    String val;
    boolean isWord;
    TrieNode[] child;
    
    public TrieNode() {
        val = "";
        isWord = false;
        child = new TrieNode[26];
        for (int i=0;i<26;i++) {
            child[i] = null;
        }
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word.length() == 0) {
            return;
        }
        TrieNode cur =root;
        
        for (int i=0;i<word.length();i++){
            TrieNode tmp = cur.child[word.charAt(i)-'a'];
            if (tmp == null){
                TrieNode n = new TrieNode();
                n.isWord = (i==word.length()-1);
                cur.child[word.charAt(i)-'a'] = n;
                cur = n;
            } else {
                if (!tmp.isWord) {
                    tmp.isWord = (i==word.length()-1);
                }
                cur = tmp;
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word.length() == 0) {
            return true;
        }
        TrieNode cur =root;
        for (int i=0;i<word.length();i++) {
            TrieNode tmp = cur.child[word.charAt(i)-'a'];
            if (tmp==null) {
                return false;
            }
            cur = tmp;
        }
        if (cur.isWord) return true;
        else return false;
        
        
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix.length() == 0) {
            return true;
        }
        TrieNode cur =root;
        for (int i=0;i<prefix.length();i++) {
            TrieNode tmp = cur.child[prefix.charAt(i)-'a'];
            if (tmp==null) {
                return false;
            }
            cur = tmp;
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");