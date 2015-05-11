
public class Trie {
	public static class TrieNode {
	    // Initialize your data structure here.
	    public List<TrieNode> children;
	    public boolean isEnd;
	    public char value;
	    public TrieNode() {
	        children = new ArrayList<TrieNode>();
	        isEnd = false;
	        value = ' ';
	    }
	    
	    public TrieNode(char c) {
	        children = new ArrayList<TrieNode>();
	        isEnd = false;
	        value = c;
	    }
	    
	    public TrieNode child(char c){
	        if(children == null){
	            return null;
	        }
	        
	        for(TrieNode node: children){
	            if(node.value == c){
	                return node;
	            }
	        }
	        return null;
	    }
	}

	public static class Trie {
	    private TrieNode root;

	    public Trie() {
	        root = new TrieNode();
	    }

	    // Inserts a word into the trie.
	    public void insert(String word) {
	        if(search(word)){
	            return;
	        }
	        TrieNode node = root;
	       for (char ch : word.toCharArray() ){
	           TrieNode child = node.child(ch);
	           if(child == null){
	               TrieNode newChild = new TrieNode(ch);
	               node.children.add(newChild);
	               node = newChild;
	           }else{
	               node = child;
	           }
	       }
	       node.isEnd = true;
	    }

	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	         TrieNode node = root;
	         for (char ch : word.toCharArray() ){
	              TrieNode child = node.child(ch);
	              if(child == null){
	                  return false;
	              }else{
	                  node = child;
	              }
	         }
	         if(node.isEnd){
	             return true;
	         }
	         return false;
	    }

	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
	         TrieNode node = root;
	         for (char ch : prefix.toCharArray() ){
	              TrieNode child = node.child(ch);
	              if(child == null){
	                  return false;
	              }else{
	                  node = child;
	              }
	         }
	         return true;
	    }
	}

	// Your Trie object will be instantiated and called as such:
	// Trie trie = new Trie();
	// trie.insert("somestring");
	// trie.search("key");
}
