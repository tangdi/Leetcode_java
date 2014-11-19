import java.util.HashSet;

public class WordSearch {
	private int height;
	private int width;
	private HashSet<String> path;
	private boolean[][] visited;

	public boolean exist(char[][] board, String word) {
		if (board == null || word == null) {
			return false;
		}
		height = board.length;
		width = board[0].length;
		visited = new boolean[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				visited[i][j] = false;
			}
		}

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (exist(board, word, i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean exist(char[][] board, String word, int i, int j,
			int match_length) {
		if (match_length == word.length()) {
			return true;
		}

		if (i >= height || j >= width || i < 0 || j < 0 || visited[i][j]) {
			return false;
		}

		char target = word.charAt(match_length);
		if (board[i][j] == target) {
			visited[i][j] = true;
			boolean result = exist(board, word, i + 1, j, match_length + 1)
					|| exist(board, word, i, j + 1, match_length + 1)
					|| exist(board, word, i - 1, j, match_length + 1)
					|| exist(board, word, i, j - 1, match_length + 1);
			visited[i][j] = false;
			return result;
		}
		return false;
	}

	public static void main(String[] args) {
		WordSearch s1 = new WordSearch();
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'E', 'S' },
				{ 'A', 'D', 'E', 'E' } };
		String word = "ABCESEEEFS";
		System.out.println(s1.exist(board, word));
	}
}
