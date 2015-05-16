import java.util.ArrayList;
import java.util.List;

public class WordDictionary {
	// Adds a word into the data structure.
	public static class TrieNode {
		public List<TrieNode> children;
		public char ch;
		public boolean end;

		public TrieNode(char c) {
			ch = c;
			end = false;
		}

		public TrieNode findChild(char c) {
			if (children == null) {
				return null;
			}
			for (TrieNode child : children) {
				if (child.ch == c) {
					return child;
				}
			}
			return null;
		}

		public void addChild(TrieNode child) {
			if (children == null) {
				children = new ArrayList<TrieNode>();
			}
			children.add(child);
		}

		public void add(String word) {
			if (word.length() == 0) {
				this.end = true;
				return;
			}
			char c = word.charAt(0);
			TrieNode child = findChild(c);
			if (child == null) {
				child = new TrieNode(c);
				addChild(child);
			}
			child.add(word.substring(1));
		}

		public boolean search(String word) {
			if (word.length() == 0) {
				return end ? true : false;
			}
			char c = word.charAt(0);
			if (c != '.') {
				TrieNode child = findChild(c);
				if (child == null) {
					return false;
				}
				return child.search(word.substring(1));
			} else {
				if (children == null) {
					return false;
				}
				for (TrieNode child : children) {
					if (child.search(word.substring(1))) {
						return true;
					}
				}
				return false;
			}
		}
	}

	private TrieNode root = new TrieNode(' ');

	public void addWord(String word) {
		root.add(word);
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		return root.search(word);
	}
	
	public static void main(String[] args) {
		WordDictionary s1 = new WordDictionary();
		s1.addWord("a");
		s1.addWord("a");
		/*s1.addWord("mad");
		System.out.println(s1.search("pad")); 
		System.out.println(s1.search("bad"));
		System.out.println(s1.search(".ad"));*/
		System.out.println(s1.search("a."));
	}
}
