package graph;

public class FloydWarshall {

	static int[][] P;
	static final int N = 4;

	public static void main(String[] args) {
		int[][] M = { { 0, 5, 999, 999 }, { 50, 0, 15, 5 }, { 30, 999, 0, 15 },
				{ 15, 999, 5, 0 } };
		P = new int[N][N];
		System.out.println("Matrix to find the shortest path of.");
		printMatrix(M);
		System.out.println("Shortest Path Matrix.");
		printMatrix(FloydAlgo(M));
		System.out.println("Path Matrix");
		printMatrix(P);
	}

	public static int[][] FloydAlgo(int[][] M) {
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (M[i][k] + M[k][j] < M[i][j]) {
						M[i][j] = M[i][k] + M[k][j];
						P[i][j] = k;
					}

				}
			}
		}
		return M;
	}

	public static int min(int i, int j) {
		if (i > j) {
			return j;
		}
		return i;
	}

	public static void printMatrix(int[][] Matrix) {
		System.out.print("\n\t");
		for (int j = 0; j < N; j++) {
			System.out.print(j + "\t");
		}
		System.out.println();
		for (int j = 0; j < 35; j++) {
			System.out.print("-");
		}
		System.out.println();
		for (int i = 0; i < N; i++) {
			System.out.print(i + " |\t");
			for (int j = 0; j < N; j++) {
				System.out.print(Matrix[i][j]);
				System.out.print("\t");
			}
			System.out.println("\n");
		}
		System.out.println("\n");
	}

}