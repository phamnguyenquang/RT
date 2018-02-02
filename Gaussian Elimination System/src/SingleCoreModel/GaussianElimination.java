package SingleCoreModel;

public class GaussianElimination {
	private double[][] A;
	private double[][] AB;
	private double[] sol;
	private double[] B;
	private boolean noSolution = false;

	public GaussianElimination(double[][] a, double[] b) {
		A = a;
		B = b;
		swap();
		MakeAugmentedMatrix();
	}

	private boolean allZero(double[] ss) {
		int k = 0;
		for (int i = 0; i < ss.length - 1; ++i) {
			if (ss[i] != 0) {
				++k;
			}

		}
		if (k == 0) {
			return true;
		} else {
			return false;
		}
	}

	private void swap() {
		int n = B.length;

		for (int p = 0; p < n; p++) {

			// find pivot row and swap
			int max = p;
			for (int i = p + 1; i < n; i++) {
				if (Math.abs(A[i][p]) > Math.abs(A[max][p])) {
					max = i;
				}
			}
			double[] temp = A[p];
			A[p] = A[max];
			A[max] = temp;
			double t = B[p];
			B[p] = B[max];
			B[max] = t;

		}
	}

	private void solve() {
		for (int pivot = 0; pivot < AB.length; ++pivot) {
			if (noSolution) {
				break;
			}
			for (int i = 0; i < AB.length; ++i) {
				if (i != pivot) {
					if (AB[i][pivot] != 0) {
						double ratio = AB[pivot][pivot] / AB[i][pivot];
						for (int j = 0; j < AB.length + 1; ++j) {
							AB[i][j] = AB[i][j] * ratio - AB[pivot][j];
						}
					}
				}
				if (allZero(AB[i])) {
					System.out.println("all zero");
					noSolution = true;
				}
			}
		}
		sol = new double[B.length];
		for (int k = 0; k < sol.length; ++k) {
			sol[k] = AB[k][AB.length] / AB[k][k];
		}

	}

	public void printSolution() {
		if (!noSolution) {
			for (int i = 0; i < sol.length; ++i) {
				System.out.println(sol[i] + " ");
			}
			System.out.println("\n");
		}
		else {
			System.out.println("no solution");
			PrintAugmented();
		}
	}

	public void printA() {
		for (int i = 0; i < B.length; ++i) {
			for (int j = 0; j < B.length; ++j) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println("\n");
		}
	}

	private void MakeAugmentedMatrix() {
		AB = new double[A.length][B.length + 1];
		for (int i = 0; i < A.length; ++i) {
			for (int j = 0; j < B.length + 1; ++j) {
				if (j == B.length) {
					AB[i][j] = B[i];
				} else {
					AB[i][j] = A[i][j];
				}
			}
		}
	}

	public void PrintAugmented() {
		for (int i = 0; i < AB.length; ++i) {
			for (int j = 0; j < AB[0].length; ++j) {
				System.out.print(AB[i][j] + " ");
			}
			System.out.println(" ");
		}
	}

	public void Substitution() {
		swap();
		solve();
		printSolution();
	}
}
