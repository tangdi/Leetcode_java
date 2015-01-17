public class DungeonGame {
	public int calculateMinimumHP(int[][] dungeon) {
		int M = dungeon.length;
		int N = dungeon[0].length;

		int[][] metric = new int[M][N];

		for (int i = M - 1; i >= 0; i--) {
			for (int j = N - 1; j >= 0; j--) {
				if (i == M - 1 && j == N - 1) {
					if (dungeon[i][j] >= 0) {
						metric[i][j] = 1;
					} else {
						metric[i][j] = -dungeon[i][j] + 1;
					}

					continue;
				}

				if (i == M - 1) {
					if (dungeon[i][j] >= 0) {
						if (dungeon[i][j] >= metric[i][j + 1]) {
							metric[i][j] = 1;
						} else {
							metric[i][j] = metric[i][j + 1] - dungeon[i][j];
						}
					} else {
						metric[i][j] = -dungeon[i][j] + metric[i][j + 1];
					}
					continue;
				}

				if (j == N - 1) {
					if (dungeon[i][j] >= 0) {
						if (dungeon[i][j] >= metric[i + 1][j]) {
							metric[i][j] = 1;
						} else {
							metric[i][j] = metric[i + 1][j] - dungeon[i][j];
						}
					} else {
						metric[i][j] = -dungeon[i][j] + metric[i + 1][j];
					}
					continue;
				}
				int better = Math.min(metric[i + 1][j], metric[i][j + 1]);
				if (dungeon[i][j] >= 0) {
					if (dungeon[i][j] >= better) {
						metric[i][j] = 1;
					} else {
						metric[i][j] = better - dungeon[i][j];
					}
				} else {
					metric[i][j] = -dungeon[i][j] + better;
				}

			}

		}
		return metric[0][0];
	}

	public static void main(String[] args) {
		DungeonGame s1 = new DungeonGame();
		int[][] dungeon = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		System.out.println(s1.calculateMinimumHP(dungeon));
	}
}
